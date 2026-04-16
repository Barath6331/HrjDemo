package com.example.hrjdemo.ui.theme.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hrjdemo.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> CommonDropdown(
    label: AnnotatedString,
    items: List<T>,
    selectedItem: T?,
    onItemSelected: (T) -> Unit,
    itemLabel: (T) -> String,
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(
            text = label, style = TextStyle(
                fontFamily = FontFamily(Font(R.font.avenirnextltpro_medium)),
                fontSize = 14.sp,
                color = colorResource(R.color.black)
            )
        )

        Spacer(modifier = Modifier.height(6.dp))

        Box {
            Text(
                text = selectedItem?.let { itemLabel(it) } ?: "Select $label",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                    fontSize = 14.sp,
                    color = colorResource(R.color.black)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .background(Color.White, RoundedCornerShape(5.dp))
                    .border(0.5.dp, Color.Gray, RoundedCornerShape(5.dp))
                    .clickable { expanded = true }
                    .padding(horizontal = 10.dp)
                    .wrapContentSize(Alignment.CenterStart)
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(R.color.white))
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                itemLabel(item),
                                style = TextStyle(
                                    fontFamily = FontFamily(Font(R.font.avenirnextltpro_regular)),
                                    fontSize = 13.sp,
                                    color = colorResource(R.color.black)
                                )
                            )
                        },
                        onClick = {
                            onItemSelected(item)
                            expanded = false
                        }
                    )
                }
            }

            Image(
                painter = painterResource(R.drawable.dropdownimage),
                contentDescription = "",
                modifier = Modifier
                    .size(23.dp)
                    .align(alignment = Alignment.CenterEnd)
                    .padding(end = 10.dp)
            )
        }
    }
}