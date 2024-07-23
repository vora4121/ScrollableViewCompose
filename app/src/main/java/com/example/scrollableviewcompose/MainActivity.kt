package com.example.scrollableviewcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scrollableviewcompose.ui.theme.ScrollableViewComposeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScrollableViewComposeTheme {
                MainView()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {

    Scaffold(
        topBar = {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .background(color = Color.Black)
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Navigation icon",
                        tint = Color.White
                    )
                }

                Row(
                    modifier = Modifier.align(alignment = Alignment.Center),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "United",
                        color = Color.White,
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_flag),
                        contentDescription = "Flag",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(start = 3.dp)
                    )

                }

                IconButton(
                    onClick = {},
                    modifier = Modifier.align(alignment = Alignment.CenterEnd)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "Shopping",
                        tint = Color.White
                    )
                }
            }
        },

        content = {

            ScrollView(
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface)
            )

            /*Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val items = (1..100).map { "Item $it" }
                val lazyListState = rememberLazyListState()
                var scrolledY = 0f
                var previousOffset = 0


                *//*Column(
                    Modifier.verticalScroll(rememberScrollState(), enabled = true)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        Text(text = "Text", color = Color.Red, fontSize = 26.sp)

                        Image(
                            painter = painterResource(id = R.drawable.main_image),
                            contentDescription = null,
                            contentScale = ContentScale.FillHeight,
                            modifier = Modifier
                                .graphicsLayer {
                                    scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                                    translationY = scrolledY * 0.5f
                                    previousOffset = lazyListState.firstVisibleItemScrollOffset
                                }
                                .height(500.dp)
                                .fillMaxWidth()
                        )
                    }

                }*/
            /*






                LazyColumn(
                    Modifier.fillMaxSize(),
                    lazyListState,
                ) {

                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                        ) {

                            Text(text = "Text", color = Color.Red, fontSize = 26.sp)

                            Image(painter = painterResource(id = R.drawable.main_image),
                                contentDescription = null,
                                contentScale = ContentScale.FillHeight,
                                modifier = Modifier
                                    .graphicsLayer {
                                        scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                                        translationY = scrolledY * 0.5f
                                        previousOffset = lazyListState.firstVisibleItemScrollOffset
                                    }
                                    .height(500.dp)
                                    .fillMaxWidth())
                        }
                    }

                    items(items) {
                        Text(
                            text = it,
                            Modifier
                                .background(Color.White)
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                    }
                }
            }*/
        })
}


@Composable
fun ScrollView(modifier: Modifier = Modifier) {

    val scroll: ScrollState = rememberScrollState(0)

    val headerHeightPx = with(LocalDensity.current) { 400.dp.toPx() }


    Box(modifier = modifier) {
        Header(
            scroll = scroll,
            headerHeightPx = headerHeightPx,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )
        Body(
            scroll = scroll,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun Header(
    scroll: ScrollState,
    headerHeightPx: Float,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .graphicsLayer {
                translationY = -scroll.value.toFloat() / 2f // Parallax effect
                alpha = (-1f / headerHeightPx) * scroll.value + 1
            }
    ) {


        Image(
            painter = painterResource(id = R.drawable.main_image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.FillBounds
        )

        Box(
            Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(colorResource(id = R.color.light_blue), Color.Transparent),
                        startY = 3 * headerHeightPx / 150
                    )
                )
        )
    }
}

@Composable
private fun Body(scroll: ScrollState, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(scroll)
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "FLY TO BARCELONA", color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )

        Text(
            text = "Experiance Gaudi's architecture throughout the \ncity >", color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )

        Box(
            modifier = Modifier
                .padding(top = 10.dp)
                .background(color = colorResource(id = R.color.dark_blue))
        ) {
            Text(
                text = "Barcelona, Spain(BCN)",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp, top = 5.dp, bottom = 5.dp, end = 10.dp)
            )
        }


        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .padding(top = 190.dp),
            colors = ButtonDefaults.buttonColors(Color.Blue),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(
                text = "SIGN IN OR JOIN NOW",
                fontSize = 18.sp, modifier = Modifier.padding(vertical = 3.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .padding(horizontal = 10.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = colorResource(id = R.color.gray))
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = "Clock",
                        modifier = Modifier
                            .size(80.dp)
                            .padding(vertical = 10.dp),
                        colorFilter = ColorFilter.tint(color = Color.White)

                    )

                    Text(text = "Check in", color = Color.White, fontSize = 16.sp)

                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = "Add a trip",
                        modifier = Modifier
                            .size(80.dp)
                            .padding(vertical = 10.dp),
                        colorFilter = ColorFilter.tint(color = Color.White)

                    )

                    Text(text = "Add a trip", color = Color.White, fontSize = 16.sp)

                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = "Wi-Fi",
                        modifier = Modifier
                            .size(80.dp)
                            .padding(vertical = 10.dp),
                        colorFilter = ColorFilter.tint(color = Color.White)

                    )

                    Text(
                        text = "Wi-Fi and \n entertainment", color = Color.White, fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            ),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 10.dp, end = 10.dp)
        ) {

            Row(horizontalArrangement = Arrangement.SpaceBetween) {

                Column() {

                    Box(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .background(color = colorResource(id = R.color.dark_blue))
                    ) {
                        Text(
                            text = "LIMITED-TIME OFFER",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(
                                start = 10.dp,
                                top = 5.dp,
                                bottom = 5.dp,
                                end = 10.dp
                            )
                        )
                    }

                    Text(
                        text = "60,000", color = Color.Black,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )

                    Text(
                        text = "BONUS MILES",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )


                }

                Box(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .width(150.dp)
                            .align(alignment = Alignment.CenterEnd)
                            .background(Color.Blue)
                    ) {

                        Text(
                            text = "$0 intro \n annual \n fee \n\n Learn more >",
                            color = Color.White,
                            fontSize = 16.sp,
                            textAlign = TextAlign.End,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterEnd)
                                .padding(end = 2.dp)
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ic_credit_card),
                        contentDescription = "card",
                        modifier = Modifier
                            .width(100.dp)
                            .height(80.dp)
                            .padding(start = 20.dp),
                        contentScale = ContentScale.FillBounds
                    )

                }

            }
        }

        Text(
            text = "Just for you", color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 10.dp)
                .padding(vertical = 20.dp)
        )

        LazyRow(
            modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            items(50){
                JustForYouComponent()
            }
        }

        Text(
            text = "More Views", color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 10.dp)
                .padding(vertical = 20.dp)
        )

        LazyRow(
            modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            items(50){
                JustForYouComponent()
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScrollableViewComposeTheme {
        MainView()
    }
}