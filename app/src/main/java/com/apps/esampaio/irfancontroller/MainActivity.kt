package com.apps.esampaio.irfancontroller


import android.content.Context
import android.hardware.ConsumerIrManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mb_sync.setOnClickListener {
            sendCommand(Commands.MB_SYNC);
        }
        hold.setOnClickListener {
            sendCommand(Commands.HOLD);
        }
        fan_speed.setOnClickListener {
            sendCommand(Commands.FAN_SPEED);
        }
        on.setOnClickListener {
            sendCommand(Commands.ON);
        }
        off.setOnClickListener {
            sendCommand(Commands.OFF);
        }

        red.setOnClickListener { sendCommand(Commands.RED) }
        green.setOnClickListener { sendCommand(Commands.GREEN) }
        blue.setOnClickListener { sendCommand(Commands.BLUE) }
        yellow.setOnClickListener { sendCommand(Commands.YELLOW) }
        purple.setOnClickListener { sendCommand(Commands.PURPLE) }
        light_blue.setOnClickListener { sendCommand(Commands.LIGHT_BLUE) }
        white.setOnClickListener { sendCommand(Commands.WHITE) }

        breath_red.setOnClickListener { sendCommand(Commands.BREATH_RED) }
        breath_green.setOnClickListener { sendCommand(Commands.BREATH_GREEN) }
        breath_blue.setOnClickListener { sendCommand(Commands.BREATH_BLUE) }
        breath_yellow.setOnClickListener { sendCommand(Commands.BREATH_YELLOW) }
        breath_purple.setOnClickListener { sendCommand(Commands.BREATH_PURPLE) }
        breath_light_blue.setOnClickListener { sendCommand(Commands.BREATH_LIGHT_BLUE) }
        breath_white.setOnClickListener { sendCommand(Commands.BREATH_WHITE) }

        colorful.setOnClickListener { sendCommand(Commands.COLORFUL) }

        preset_1.setOnClickListener { sendCommand(Commands.PRESET_1) }
        preset_2.setOnClickListener { sendCommand(Commands.PRESET_2) }
        preset_3.setOnClickListener { sendCommand(Commands.PRESET_3) }
        preset_4.setOnClickListener { sendCommand(Commands.PRESET_4) }
    }


    private fun sendCommand(command: IntArray ) {
        val manager =
            applicationContext.getSystemService(Context.CONSUMER_IR_SERVICE) as ConsumerIrManager

//        for(freq in manager.carrierFrequencies) {
        val freq = manager.carrierFrequencies[0]
        manager.transmit(freq.minFrequency, command)
//        }


    }

}
