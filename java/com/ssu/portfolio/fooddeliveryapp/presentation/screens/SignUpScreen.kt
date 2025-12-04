package com.ssu.portfolio.fooddeliveryapp.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.ssu.portfolio.fooddeliveryapp.R
import com.ssu.portfolio.fooddeliveryapp.data.models.userData
import com.ssu.portfolio.fooddeliveryapp.presentation.components.OrComponent
import com.ssu.portfolio.fooddeliveryapp.presentation.navigation.Routes
import com.ssu.portfolio.fooddeliveryapp.presentation.navigation.SubNavigation
import com.ssu.portfolio.fooddeliveryapp.presentation.viewModel.ZomViewModel

// ------------------- SIGNUP SCREEN -------------------
@Composable
fun SignUpScreen(
    viewModel: ZomViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.signUpScreenState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            state.errorMessage != null -> {
                Text(
                    text = state.errorMessage!!,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> {
                SignUpContent(navController = navController, viewModel = viewModel)
            }
        }
    }
}

@Composable
fun SignUpContent(
    navController: NavController,
    viewModel: ZomViewModel
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // Header Image + Skip Button
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(R.drawable.komatosignup),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = { navController.navigate(SubNavigation.MainHomeScreen) },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                        .size(width = 78.dp, height = 35.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        colorResource(R.color.purple_700),
                        contentColor = Color.White
                    )
                ) {
                    Text("Skip", fontSize = 14.sp)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Titles
            Text("Get Started", fontSize = 44.sp, fontWeight = FontWeight.Bold)
            Text("by creating a free account", fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(24.dp))

            // Input Fields
            MyTextField(fullName, { fullName = it }, "Full Name", painterResource(R.drawable.userprofile))
            Spacer(modifier = Modifier.height(12.dp))
            MyTextField(email, { email = it }, "Email", painterResource(R.drawable.mail), KeyboardType.Email)
            Spacer(modifier = Modifier.height(12.dp))
            MyTextField(address, { address = it }, "Address", painterResource(R.drawable.address))
            Spacer(modifier = Modifier.height(12.dp))
            PasswordTextField(password, { password = it }, "Password", painterResource(R.drawable.padlock))
            Spacer(modifier = Modifier.height(12.dp))
            PasswordTextField(confirmPassword, { confirmPassword = it }, "Confirm Password", painterResource(R.drawable.padlock))
            Spacer(modifier = Modifier.height(24.dp))

            // Next Button
            Button(
                onClick = {
                    when {
                        fullName.isBlank() || email.isBlank() || address.isBlank() || password.isBlank() || confirmPassword.isBlank() -> {
                            Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                        }
                        password != confirmPassword -> {
                            Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            val user = userData(
                                username = fullName,
                                email = email,
                                address = address,
                                password = password
                            )
                            viewModel.createUser(user)
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                      colorResource(R.color.addButtonRed),
                    contentColor = Color.White
                )
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Next", fontSize = 20.sp, fontWeight = FontWeight.Medium)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Login Link
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Already a member? ", fontSize = 16.sp)
                Text(
                    "Login",
                    color = colorResource(R.color.addButtonRed),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable {
                        navController.navigate(Routes.LoginScreen)
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // OR Divider
            OrComponent()
        }
    }
}

// --- Reusable TextField ---
@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderValue: String,
    leadingIcon: Painter,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholderValue, color = Color.Gray) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.LightGray,
            focusedBorderColor = colorResource(R.color.addButtonRed),
            cursorColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        leadingIcon = {
            Icon(
                painter = leadingIcon,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Color.Gray
            )
        }
    )
}

// --- Password Field with Toggle ---
@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderValue: String,
    leadingIcon: Painter
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholderValue, color = Color.Gray) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.LightGray,
            focusedBorderColor = colorResource(R.color.addButtonRed),
            cursorColor = Color.Black
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Icon(
                painter = leadingIcon,
                contentDescription = null,
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
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}