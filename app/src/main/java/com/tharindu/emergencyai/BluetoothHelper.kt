package com.tharindu.emergencyai

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import java.io.IOException
import java.util.*

object BluetoothHelper {
    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    private val uuid: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB") // Standard SPP UUID

    fun sendMessage(message: String, callback: (String) -> Unit) {
        if (bluetoothAdapter == null) {
            callback("Bluetooth not supported on this device.")
            return
        }

        if (!bluetoothAdapter.isEnabled) {
            callback("Please enable Bluetooth first.")
            return
        }

        val device: BluetoothDevice? = bluetoothAdapter.bondedDevices.firstOrNull()
        if (device == null) {
            callback("No paired Bluetooth devices found.")
            return
        }

        try {
            val socket: BluetoothSocket = device.createRfcommSocketToServiceRecord(uuid)
            socket.connect()
            val outputStream = socket.outputStream
            outputStream.write(message.toByteArray())
            outputStream.flush()
            socket.close()
            callback("Message sent successfully to ${device.name}")
        } catch (e: IOException) {
            callback("Error sending message: ${e.message}")
        }
    }
}
