




import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * 底部弹出菜单栏
 * @version 2.0
 */
public class AlertWindow{
	private Dialog          mDialog;
	private Context         mContext;
	private OnClickListener mOneClickListenr    = null;
	private OnClickListener mTwoClickListenr    = null;
	
	private OnClickListener mMidClickListenr    = null;
	private OnClickListener mCloseClickListener = null;
	private Button btn_window_title, btnOne,btnMid,btnClose,btn_three;
	
	public AlertWindow(){}
	
	public AlertWindow(Context context)
	{
		this.mContext = context;
	}
	
	public Dialog showAlert()
	{
		mDialog = new Dialog(mContext, R.style.AlertWindowTheme);
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.alert_dialog_menu_layout, null);
		final int cFullFillWidth = 10000;
		layout.setMinimumWidth(cFullFillWidth);
		btn_window_title = (Button) layout.findViewById(R.id.btn_window_title);
		btnOne = (Button) layout.findViewById(R.id.btnOne);
		btnMid = (Button) layout.findViewById(R.id.btnMid);	
		btn_three = (Button) layout.findViewById(R.id.btn_three);
		btnClose = (Button) layout.findViewById(R.id.btnClose);
		
		btnOne.setOnClickListener(oneClickListenr);
		btn_three.setOnClickListener(twoClickListenr);
		btnMid.setOnClickListener(midClickListenr);
		btnClose.setOnClickListener(closeClickListener);
		
		Window w = mDialog.getWindow();
		WindowManager.LayoutParams lp = w.getAttributes();
		lp.x = 0;
		final int cMakeBottom = -1000;
		lp.y = cMakeBottom;
		lp.gravity = Gravity.BOTTOM;
		mDialog.onWindowAttributesChanged(lp);
		mDialog.setCanceledOnTouchOutside(true);
		mDialog.setContentView(layout);
		mDialog.show();
		return mDialog;
	}
	
	/**
	 * 判断对话框是否弹起来
	 * @return
	 */
	public boolean isShowing()
	{
		if(mDialog != null && mDialog.isShowing())
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 关闭对话框
	 */
	public void dismiss()
	{
		if(mDialog != null)
		{
			mDialog.dismiss();
			mDialog = null;
		}
	}
	
	/**
	 * 设置第一个按钮的监听事件
	 * @param l
	 */
	public void setOnOneListener(OnClickListener l) {
		mOneClickListenr = l;
	}
	
	/**
	 * 设置第2个按钮的监听事件
	 * @param l
	 */
	public void setOnTwoListener(OnClickListener l) {
		mTwoClickListenr = l;
	}
	
	/**
	 * 设置第3按钮的监听事件
	 * @param l
	 */
	public void setOnMidListener(OnClickListener l) {
		mMidClickListenr = l;
	}
	
	/**
	 * 设置关闭按钮的监听事件
	 * @param l
	 */
	public void setOnCloseListener(OnClickListener l){
		mCloseClickListener = l;
	}
	
	/**
	 * 第一个按钮的点击监听
	 */
	private  OnClickListener oneClickListenr = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mOneClickListenr != null){
				mOneClickListenr.onClick(v);
			}
		}
	};
	
	/**
	 * 第2个按钮的点击监听
	 */
	private  OnClickListener twoClickListenr = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mTwoClickListenr != null){
				mTwoClickListenr.onClick(v);
			}
		}
	};
	/**
	 * 第3个按钮的点击监听
	 */
	private  OnClickListener midClickListenr = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (mMidClickListenr != null){
				mMidClickListenr.onClick(v);
			}
		}
	};
	
	/**
	 * 关闭按钮的点击事件
	 */
	private OnClickListener closeClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if(mCloseClickListener != null){
				mCloseClickListener.onClick(v);
			}
		}
	};
	public void  setButtonContent (String title,String one,String two,String three,String end){
		
		
		setButtonStatic(btn_window_title,title);
		setButtonStatic(btnOne,one);
		setButtonStatic(btnMid,two);
		setButtonStatic(btn_three,three);
		setButtonStatic(btnClose,end);
		this.btn_window_title.setText(title);
		this.btnOne.setText(one);
		this.btnMid.setText(two);
		this.btn_three.setText(three);
		this.btnClose .setText(end);
		
	}
	private void setButtonStatic(Button button,String btnContent) {
		// TODO Auto-generated method stub
		
		
if (!btnContent.equals("")){
	
	button.setText(btnContent);
		}else {
			button.setVisibility(View.GONE);
		}
	}

	public void setVisiable(){
		
	}
}
