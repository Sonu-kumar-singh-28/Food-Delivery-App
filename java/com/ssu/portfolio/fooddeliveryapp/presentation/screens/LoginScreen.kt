package com.ssu.portfolio.fooddeliveryapp.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.ssu.portfolio.fooddeliveryapp.R
import com.ssu.portfolio.fooddeliveryapp.presentation.components.OrComponent
import com.ssu.portfolio.fooddeliveryapp.presentation.navigation.Routes
import com.ssu.portfolio.fooddeliveryapp.presentation.navigation.SubNavigation
import com.ssu.portfolio.fooddeliveryapp.presentation.viewModel.ZomViewModel

@Composable
fun LoginScreen(
    viewModel: ZomViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.loginScreenState.collectAsStateWithLifecycle()  // Fixed: use 'by'
    val context = LocalContext.current

    // Navigation on success
    if (state.isSuccess) {
        LaunchedEffect(Unit) {
            navController.navigate(SubNavigation.MainHomeScreen) {
                popUpTo(navController.graph.startDestinationId) { inclusive = true }
                launchSingleTop = true
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            state.errorMessage != null -> {
                Text(
                    text = state.errorMessage!!,
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Red
                )
            }
            else -> {
                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }

                Column(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(R.drawable.komatologin),
                            contentDescription = "Komato Image",
                            modifier = Modifier.fillMaxWidth()
                        )
                        Button(
                            onClick = { navController.navigate(SubNavigation.MainHomeScreen) },
                            modifier = Modifier
                                .padding(vertical = 50.dp, horizontal = 16.dp)
                                .align(Alignment.TopEnd)
                                .clip(CircleShape)
                                .size(width = 78.dp, height = 35.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.DarkGray.copy(alpha = 0.8f),
                                contentColor = Color.LightGray
                            ),
                            shape = CircleShape,
                            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
                        ) {
                            Text(text = "Skip")
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(horizontal = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "India's #1 Food Delivery",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "and Dining App",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Divider(
                                modifier = Modifier.width(130.dp),
                                color = Color.LightGray,
                                thickness = 0.8.dp
                            )
                            Text(
                                text = "Login or sign up",
                                modifier = Modifier.padding(8.dp),
                                color = Color.DarkGray,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp
                            )
                            Divider(
                                modifier = Modifier.width(130.dp),
                                color = Color.LightGray,
                                thickness = 0.8.dp
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        EmailTextField(
                            value = email,
                            onValueChange = { email = it },
                            placeholderValue = "Email",
                            painterResource = painterResource(R.drawable.mail)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        LoginPasswordTextField(
                            value = password,
                            onValueChange = { password = it },
                            placeholderValue = "Password",
                            painterResource = painterResource(R.drawable.padlock)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Button(
                            onClick = {
                                if (email.isNotBlank() && password.isNotBlank()) {
                                    viewModel.loginUser(email, password)  // This will set isSuccess = true
                                } else {
                                    Toast.makeText(context, "Please fill all the details", Toast.LENGTH_LONG).show()
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 30.dp, vertical = 10.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.addButtonRed),
                                contentColor = Color.White
                            ),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 8.dp,
                                pressedElevation = 12.dp
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(text = "Login", fontSize = 22.sp)
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Don't have an account?")
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Signup",
                                modifier = Modifier.clickable {
                                    navController.navigate(Routes.SignUpScreen)
                                },
                                color = colorResource(R.color.addButtonRed)
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        OrComponent()

                        Spacer(modifier = Modifier.height(10.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "By Continuing, you agree to our",
                                fontSize = 12.sp,
                                color = Color.DarkGray
                            )
                            Text(
                                text = "Terms of Services Privacy Policy Content Policy",
                                fontSize = 12.sp,
                                color = Color.DarkGray
                            )
                        }
                    }
                }
            }
        }
    }
}

// Reusable Email Field
@Composable
fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderValue: String,
    painterResource: Painter
) {
    OutlinedTextField(  // Changed to OutlinedTextField (shows border)
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholderValue, color = Color.Gray) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        singleLine = true,
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = "Icon",
                modifier = Modifier.size(20.dp),
                tint = Color.Gray
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(R.color.addButtonRed),
            unfocusedBorderColor = Color.LightGray
        )
    )
}

// Reusable Password Field
@Composable
fun LoginPasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderValue: String,
    painterResource: Painter
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholderValue, color = Color.Gray) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        singleLine = true,
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = "Icon",
                modifier = Modifier.size(20.dp),
                tint = Color.Gray
            )
        },
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = if (passwordVisible) "Hide" else "Show",
                    tint = Color.Gray
                )
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(R.color.addButtonRed),
            unfocusedBorderColor = Color.LightGray
        )
    )
}