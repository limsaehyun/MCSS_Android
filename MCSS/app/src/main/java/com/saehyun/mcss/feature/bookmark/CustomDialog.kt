package com.saehyun.mcss.feature.bookmark

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.saehyun.mcss.R


class CustomDialog(context: Context) {
    private val dlg = Dialog(context)   //부모 액티비티의 context 가 들어감
    private lateinit var etSrvName: EditText
    private lateinit var etSrvDomain: EditText
    private lateinit var tvCancel: TextView
    private lateinit var tvAdd: TextView

    var name: MutableLiveData<String> = MutableLiveData()
    var domain: MutableLiveData<String> = MutableLiveData()
    var success: MutableLiveData<Boolean> = MutableLiveData()
//    private lateinit var listener: CustomDialogOKClickedListener

    fun start() {
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dlg.setContentView(R.layout.bookmark_add)     //다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함

        etSrvName = dlg.findViewById(R.id.etSrvName)

        etSrvDomain = dlg.findViewById(R.id.etSrvDomain)

        tvAdd = dlg.findViewById(R.id.tvAdd)
        tvAdd.setOnClickListener {

//            listener.onOkCliked("OK")
            if(etSrvName.text.isNotEmpty() || etSrvDomain.text.isNotEmpty())  {
                name.value = etSrvName.text.toString()
                domain.value = etSrvDomain.text.toString()
                success.value = true

                dlg.dismiss()
            }

        }

        tvCancel = dlg.findViewById(R.id.tvCancel)
        tvCancel.setOnClickListener {
            dlg.dismiss()
        }

        dlg.show()
    }
}