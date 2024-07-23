package com.example.scrollableviewcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scrollableviewcompose.ui.theme.ScrollableViewComposeTheme

@Composable
fun JustForYouComponent() {

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(horizontal = 10.dp).width(250.dp)
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.main_image),
                contentDescription = "main",
                contentScale = ContentScale.Crop,
                modifier = Modifier.width(300.dp)
            )

            Text(text = "Sign up for texts from\nUnited",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp)
            )

            Text(text = "Unlock exclusive deals and\nupdates",
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp)
            )

            Text(text = "Join today >",
                color = colorResource(id = R.color.dark_blue),
                modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
            )


        }

    }


}


@Preview(showBackground = true)
@Composable
fun ViewComponents() {
    ScrollableViewComposeTheme {
        JustForYouComponent()
    }
}