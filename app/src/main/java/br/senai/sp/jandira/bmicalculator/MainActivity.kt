package br.senai.sp.jandira.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BMICalculatorTheme {
                CalculatorScreen()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CalculatorScreen() {

    var weightState = remember {
        mutableStateOf(0)
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bmi),
                    contentDescription = "",
                    Modifier.size(100.dp)
                )
                Text(
                    text = stringResource(id = R.string.title),
                    fontSize = 32.sp,
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 4.sp
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.weight_label),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                )
                Text(
                    text = stringResource(id = R.string.height_label),
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                )
                OutlinedTextField(
                    value = "Senai",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                )
                Spacer(modifier = Modifier.height(48.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        stringResource(id = R.string.button_calculate),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            //footer
            Column() {
                Card(
                    modifier = Modifier.fillMaxSize(),
                    shape = RoundedCornerShape(
                        topStart = 48.dp,
                        topEnd = 48.dp
                    ),
                    backgroundColor = Color(
                        red = 79,
                        green = 54,
                        blue = 232
                    )

                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.your_score),
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "0.0",
                            color = Color.White,
                            fontSize = 48.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(id = R.string.ideal_state),
                            color = Color.White,
                            fontSize = 20.sp
                        )
                        Row() {
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = stringResource(id = R.string.reset))
                            }
                            Spacer(modifier = Modifier.width(24.dp))
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = stringResource(id = R.string.share))
                            }
                        }
                    }
                }
            }
        }
    }
}