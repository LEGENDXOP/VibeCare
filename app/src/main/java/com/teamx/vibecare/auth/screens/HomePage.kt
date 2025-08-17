//package com.teamx.vibecare.auth.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.R
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountCircle
//import androidx.compose.material.icons.filled.AddCircle
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//
//
//@Preview
//@Composable
//fun Homepage(modifier: Modifier = Modifier) {
//
//    Column(){
//
//        Row(){
//            Column {
//                Text("Hello Welcome")
//                Text("Albert Stevano")
//            }
//            IconButton( onClick = { /*TODO*/  } ) {
//                Icon(Icons.Filled.AccountCircle, contentDescription = "Profile Icon")
//            }
//
//        }
//
//        TextField(
//            value = "",
//            onValueChange = {},
//            label = { Text("Search") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        LazyRow(){
//            items(10) { index ->
//                button(name = "Button $index", isClicked = "small")
//            }
//        }
//
//
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
//            contentPadding = PaddingValues(16.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            horizontalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//
//            item {
//                list(item = sqlist(R.drawable.ic_launcher_background, "Depressed"), navController = NavHostController())
//            }
//
//        }
//
//
//
//
//    }
//
//}
//
//
//@Composable
//fun button(name: String, isClicked: String) {
//    Button(onClick = { },
//        modifier = Modifier
//            .height(30.dp)
//            .width(120.dp)
//            .weight(0.3f)
//            .background(
//                color = if (isClicked == "small") Color(0xFF220C02) else Color.Transparent,  // Fill background color
//                shape = RoundedCornerShape(20.dp)
//            )
//            .border(
//                width = 2.dp,
//                color = Color(0xFF8A5742),
//                shape = RoundedCornerShape(20.dp)
//            ),
//        colors = ButtonDefaults.buttonColors(
//            containerColor = if (isClicked=="small") Color(0xFF220C02) else Color.Transparent,
//            contentColor = if (isClicked=="small") Color.White else Color(0xFF220C02)
//        ),
//        contentPadding = PaddingValues(0.dp)
//
//
//    ) {
//        Text(text = name, fontSize = 15.sp)
//
//    }
//}
//
//@Composable
//fun list(item:sqlist, navController: NavHostController) {
//
//    Row(
//        modifier = Modifier.fillMaxWidth().clickable {  },
//        horizontalArrangement = Arrangement.SpaceEvenly
//    ) {
//
//        Column(
//            modifier = Modifier
//                .height(200.dp).clickable {  }
//                .width(160.dp)
//                .background(
//                    Color(0xFFE3D8D3),
//                    shape = RoundedCornerShape(15.dp)
//                )
//                .border(
//                    width = 1.dp,
//                    color = Color.Black,
//                    shape = RoundedCornerShape(15.dp)
//                )
//            ,
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Image(
//                painter = painterResource(id = item.img), contentDescription = null,
//                modifier = Modifier
//                    .background(
//                        color = Color.White,
//                        shape = RoundedCornerShape(10.dp)
//                    )
//                    .height(110.dp)
//                    .width(140.dp).clickable { }
//            )
//
//
//
//            Text(
//                text = item.text,
//                color = Color(0xFF220C02),
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 10.dp, top = 5.dp)
//            )
//
//
//            Spacer(modifier = Modifier.padding(5.dp))
//
//            Row(
//
//                modifier = Modifier
//                    .fillMaxWidth().clickable { navController.navigate(screen.coffeedetail.route) }
//                    .padding(start = 10.dp, end = 10.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(text = item.price, fontSize = 17.sp, fontWeight = FontWeight.Bold)
//                Icon(
//                    imageVector = Icons.Default.AddCircle,
//                    contentDescription = null,
//                    Modifier.size(30.dp)
//                )
//            }
//
//        }
//
//
//
//
//
//
//
//    }
//}
//
//data class sqlist(val img:Int,val text:String,val price:String)
//
//val lists=  listOf(
//    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),
//    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),
//
//    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),
//    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),
//
//    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),
//    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),
//
//    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),
//    sqlist(R.drawable.cold_coffee,"Frappuciono","250")
//
//)
