package com.saehyun.mcss.feature.bookmark

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.EditText
import com.saehyun.mcss.R

class CustomDialog(context: Context)
{
    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun showDialog()
    {

        dialog.setContentView(R.layout.bookmark_add)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        val etSrvName = dialog.findViewById<EditText>(R.id.etSrvName)
        val tvAdd = dialog.findViewById<EditText>(R.id.tvAdd)
        val tvCancel = dialog.findViewById<EditText>(R.id.tvCancel)

        tvAdd.setOnClickListener {
            dialog.dismiss()
        }

        tvCancel.setOnClickListener {
            dialog.dismiss()
        }

    }

    interface OnDialogClickListener
    {
        fun onClicked(name: String)
    }

}