package com.example.vision4uapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    var notificationEnabled by remember { mutableStateOf(true) }
    var locationEnabled by remember { mutableStateOf(true) }
    var autoUpdateEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Device Information
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Thông tin thiết bị",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                SettingsRow("Tên thiết bị", "Vision4U Smart Glasses")
                SettingsRow("Trạng thái kết nối", "Mất kết nối")
                SettingsRow("Lần cuối kết nối", "Không xác định")
            }
        }

        // Notification Settings
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Thông báo",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                SettingsSwitch(
                    "Cảnh báo sức khoẻ",
                    "Nhận thông báo khi có bất thường về sức khoẻ",
                    notificationEnabled
                ) { notificationEnabled = it }
                SettingsSwitch(
                    "Cảnh báo vị trí",
                    "Thông báo khi ra khỏi vùng an toàn",
                    locationEnabled
                ) { locationEnabled = it }
                SettingsSwitch(
                    "Theo dõi vị trí liên tục",
                    "Cập nhật vị trí mỗi 5 phút",
                    autoUpdateEnabled
                ) { autoUpdateEnabled = it }
            }
        }

        // Emergency Contacts
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Liên hệ khẩn cấp",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                SettingsRow("Số điện thoại chính", "+84 901 234 567")
                SettingsRow("Số điện thoại phụ", "+84 987 654 321")
                TextButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Chỉnh sửa danh bạ")
                }
            }
        }

        // Support
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Hỗ trợ",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Hướng dẫn sử dụng")
                }
                TextButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Câu hỏi thường gặp")
                }
                TextButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Liên hệ hỗ trợ")
                }
            }
        }

        // App Info
        Text(
            text = "Vision4U Companion App",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Phiên bản 1.0.0",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun SettingsRow(
    title: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
private fun SettingsSwitch(
    title: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}
