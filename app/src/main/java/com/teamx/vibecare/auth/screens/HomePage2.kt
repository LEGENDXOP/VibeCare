package com.teamx.vibecare.auth.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.BlendMode.Companion.Color
//import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamx.vibecare.auth.utils.AuthViewModel
import com.teamx.vibecare.R
//import androidx.lifecycle.ViewModel
import com.teamx.vibecare.auth.utils.AuthUtils


@Composable
fun homepage2(modifier: Modifier,viewModel: AuthViewModel) {
//    val fullName by viewModel.name.collectAsStateWithLifecycle()
    var bt1: Boolean  by remember { mutableStateOf(false) }
    var bt2: Boolean  by remember { mutableStateOf(false) }
    var bt3: Boolean  by remember { mutableStateOf(false) }
    var bt4: Boolean  by remember { mutableStateOf(false) }
    val fullName by remember { mutableStateOf("Lokesh") }
    val buttonNames = listOf("All Items", "Depressed", "Fun", "Casual")
    var selectedButton by remember { mutableStateOf(buttonNames[0]) }
    Column(modifier = modifier
        .fillMaxSize()
        .padding(top = 40.dp, start = 13.dp, end = 13.dp)
        .background(Color.White)
    ) {

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(text = " Hello, Welcome")
                Text(text = " $fullName", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            }
            IconButton(onClick = { /* to do */ }) {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = " ",
                    tint = Color(AuthUtils.LIGHT_BLUE), modifier = Modifier.size(45.dp))
            }

        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.Center,
            verticalAlignment = Alignment.CenterVertically) {
            searchBarFun(modifier = Modifier.weight(1f))

            Card(modifier = Modifier.size(55.dp)
                .clickable(onClick = {     })
                .align(alignment = Alignment.CenterVertically),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(15.dp)
            ){

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.filter),
                        contentDescription = "Filter",
                        tint = Color(AuthUtils.PRIMARY_BLUE),
                        modifier = Modifier.size(30.dp)
                    )
                }

            }

        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            buttonNames.forEach { it->
               buttonFuction(
                   name = it,
                   isSelected = it == selectedButton,
                   onclick = { selectedButton = it }

               )
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {


            items(lists) { it->
                listFun(it)
            }

        }


    }

}

@Composable
fun buttonFuction(name: String, isSelected: Boolean, onclick: () -> Unit){
    Button(onClick = onclick,
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = if(isSelected) Color.White else Color.Black,
            containerColor = if(isSelected) Color(AuthUtils.PRIMARY_BLUE) else Color(AuthUtils.LIGHT_BLUE)
        ),
        modifier = Modifier
            .padding(horizontal = 5.dp)) {
        Text(text =  name, fontSize = 13.sp)
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchBarFun(modifier: Modifier = Modifier) {
    //sort or filter bhi esi me hain
    var expended by remember { mutableStateOf(false) }
    var myQuery by remember { mutableStateOf("") }
    var myActive by remember { mutableStateOf(false) }
    var isExpended by remember { mutableStateOf(false) }
    var OptoinList = listOf("option 1", "option 2", "option 3") // dummy list
    var selectected by remember { mutableStateOf("") }
        SearchBar(
            modifier = modifier
                .height(60.dp)
                .padding(vertical = 0.dp, horizontal = 10.dp),
            windowInsets = WindowInsets(top = 0.dp),
            query = myQuery,
            onQueryChange = { myQuery = it },
            active = myActive,
            onSearch = {
                if (myQuery.isEmpty()) {
                    myActive = false

                } else {
                    // search history to be added in the search histroy list
                }
                myActive = false
//                        searchResult = result(it)
                myQuery = ""
            },
            onActiveChange = { myActive = it },
            placeholder = { Text(text = "Search any product ...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = " Search Icon"
                )
            },
            trailingIcon = {
                if (myActive) {
                    IconButton(onClick = {
                        if (myQuery.isNotEmpty()) {
                            myQuery = ""
                        } else {
                            myActive = false
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close Search Bar"
                        )
                    }
                }
            },
            shape = RoundedCornerShape(30.dp),
            colors = SearchBarDefaults.colors(
                containerColor = Color(AuthUtils.LIGHT_BLUE)
            )
        ) {
            //search result yha dikhenge
        }
}

@Composable
fun listFun(item:sqlist) {
    Card(modifier = Modifier,
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(AuthUtils.LIGHT_BLUE)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
        ) {
        Column {
            Row {
                Image(painter = painterResource(id = item.img), contentDescription = null,
                    modifier = Modifier)

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {

                Text(
                    text = item.text,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp, top = 8.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "$" + item.price,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(15.dp))

            }
        }
    }


}

