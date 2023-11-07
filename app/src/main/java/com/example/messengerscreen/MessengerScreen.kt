package com.example.messengerscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessengerScreen(){
Column(modifier = Modifier
   .fillMaxSize()
   .padding(PaddingValues(12.dp))){
   Row(modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween){
      Row{
         CoilImage(imageUrl = "https://media.licdn.com/dms/image/D4D03AQGRrelmtOOESQ/profile-displayphoto-shrink_800_800/0/1675260981289?e=2147483647&v=beta&t=6kiSZY2CW-6XefgyrfCptldIStLaGpmP93ORyBOLjN8"
         , modifier = Modifier
               .size(40.dp)
               .clip(RoundedCornerShape(100)))
         Spacer(modifier = Modifier.width(15.dp))
         Text(text = "Chats", fontWeight = FontWeight.Bold, fontSize = 25.sp, color = colorResource(
            id = R.color.title
         ))
      }
      Box(
         modifier = Modifier
            .clip(RoundedCornerShape(100))
            .background(shape = RoundedCornerShape(100),
               color = colorResource(id = R.color.icon_background))
            .size(40.dp)
            .padding(3.dp),
         contentAlignment = Alignment.Center
      ){
         Icon(imageVector = Icons.Default.Create ,
            contentDescription = "",
            tint = colorResource(id = R.color.title),
         )
      }

   }

Spacer(modifier = Modifier.height(15.dp))
   TextField(
      value = "",
      onValueChange = {
      },
      modifier = Modifier
         .fillMaxWidth()
         .height(50.dp)
         .clip(RoundedCornerShape(50))
         .background(color = colorResource(id = R.color.text_filed_background)),
      colors = TextFieldDefaults.textFieldColors(
         containerColor = colorResource(id = R.color.text_filed_background),
         unfocusedIndicatorColor = colorResource(id = R.color.text_filed_background)
      ),
      placeholder = {
          Row(modifier = Modifier
             .fillMaxWidth(),
             horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically){
             Icon(imageVector = Icons.Default.Search,
                contentDescription = "", tint = colorResource(id = R.color.search_Text))
             Spacer(modifier = Modifier.width(6.dp))
             Text(text = "Search", fontSize = 17.sp, color = colorResource(id = R.color.search_Text))
          }
      }
   )
   Spacer(modifier = Modifier.height(15.dp))
   LazyRow(
      contentPadding = PaddingValues(5.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(5.dp)
   ){
      items(listOf(1,1,1,1,1,1,1,1,1)){
         ActiveUserItem("habibellah ayata")
      }
   }
   Spacer(modifier = Modifier.height(10.dp))
   LazyColumn{
      items(listOf(1,1,1,1,1,1,1,1,1,2)){
         MessageFriendItem()
      }
   }
}
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview(){
   MessengerScreen()
}