package com.example.messengerscreen

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import java.util.Locale

@Composable
fun ActiveUserItem(userName : String) {
   Column(horizontalAlignment = Alignment.CenterHorizontally) {
      ProfileImage()
      Text(
         text = userName.take(10) ,
         fontSize = 17.sp ,
         fontWeight = FontWeight.Normal ,
         maxLines = 1,
         color = colorResource(
            id = R.color.title
         )
      )
   }
}

@Composable
fun MessageFriendItem() {
     Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
           .height(80.dp)
           .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){
        ProfileImage()

        Column(verticalArrangement = Arrangement.SpaceAround,
           modifier = Modifier.fillMaxHeight()){
           Text(
              text = stringResource(id = R.string.userName) ,
              fontSize = 18.sp ,
              fontWeight = FontWeight.Medium ,
              maxLines = 1,
              color = colorResource(
                 id = R.color.title
              )
           )
           Text(text = stringResource(id = R.string.greeting), color = Color.Gray)
        }
        Text(text = ".22:25",
           textAlign = TextAlign.End,
           color = Color.Gray,
           modifier = Modifier.fillMaxWidth(),
           fontSize = 13.sp,
        )
     }

}

//to get the current language
@Composable
fun GetCurrentLocale(): Locale {
   val configuration = LocalContext.current.resources.configuration

   return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      configuration.locales[0]
   } else {
      @Suppress("DEPRECATION")
      configuration.locale
   }
}

//for multiple screen sizes
/*
 val screenWidth = LocalConfiguration.current.screenWidthDp

    if (screenWidth > 600.dp) {
        // Larger screen layout
        // ...
    } else {
        // Smaller screen layout
        // ...
    }
 */
//handling orientation
/*
  val orientation = LocalConfiguration.current.orientation

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Landscape layout
            // ...
        } else {
            // Portrait layout
            // ...
        }
    }
 */
@Composable
fun ProfileImage() {
   Box(
      modifier = Modifier
         .height(70.dp)
         .width(70.dp) ,
      contentAlignment = Alignment.BottomEnd
   ) {
      CoilImage(
         imageUrl = "https://media.licdn.com/dms/image/D4D03AQGRrelmtOOESQ/profile-displayphoto-shrink_800_800/0/1675260981289?e=2147483647&v=beta&t=6kiSZY2CW-6XefgyrfCptldIStLaGpmP93ORyBOLjN8" ,
         modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(100))
      )
      Column(
         modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp , start = 48.dp) ,
         horizontalAlignment = Alignment.CenterHorizontally
      ) {
         Button(
            onClick = { /*TODO*/ } , modifier = Modifier
               .clip(RoundedCornerShape(100))
               .background(color = colorResource(id = R.color.stroke_active))
               .padding(4.dp)
               .height(15.dp)
               .width(15.dp) , colors = ButtonDefaults.buttonColors(Color.Green)
         ) {
         }
      }
   }
}

@Composable
fun CoilImage(modifier : Modifier = Modifier , imageUrl : String) {
   SubcomposeAsyncImage(
      model = imageUrl ,
      contentScale = ContentScale.Crop ,
      contentDescription = "movie image" ,
      modifier = modifier.background(shape = RoundedCornerShape(100), color = Color.Transparent)
   )
}

@Preview(showBackground = true , name = "composables")
@Composable
fun ComposablesPreview() {
   MessageFriendItem()
}