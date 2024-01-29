package control.nhaphang;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import control.baocaocontrol;
import control.ketoa.dstoacontrol;
import form.main.Mainframe;
import form.nhaphang.nhaphangform;
import form.nhaphang.tabnhaphang;
import model.nhacungcap.nhacungcap;
import model.phieunhap.chitiet;
import model.phieunhap.thongtinphieu;
import model.thuoc.id;
import model.thuoc.thuoc;

public class nhaphangcontrol {

	public static void back() {
		tabnhaphang.tabbedPane.setSelectedIndex(0);
	}
	public static void newtable() {
		DefaultTableModel model =new DefaultTableModel(new Object[][] {},
				new String[] { "Mã thuốc","Hãng","Đơn vị", "Số lượng","Ngày hết hạn","Đơn giá"}) {
			boolean[] columnEditables = new boolean[] { false, false,false, false ,false,false};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		nhaphangform.table.setModel(model);
		nhaphangform.table.getTableHeader().setReorderingAllowed(false);
		tinhtien();
	}
	public static void checkdv() {
		String thuoc=nhaphangform.mathuoc.getText();
		String hang=nhaphangform.hang.getText();
		DefaultComboBoxModel model=new DefaultComboBoxModel();
		for(thuoc a:Mainframe.kho.listthuoc) {
			if(a.getMathuoc().trim().equals(thuoc)&&a.getHangthuoc().trim().equals(hang)){
				model.addElement(a.getDonvi().getTen());
			}
		}	
		nhaphangform.dv.setModel(model);
		if(model.getSize()>0) 
			nhaphangform.dv.setEnabled(true);	
		else 
			nhaphangform.dv.setEnabled(false);
	}
	public static void tinhtien() {
		int sum=0;		
		DefaultTableModel model= (DefaultTableModel)nhaphangform.table.getModel();
		for(int i=0;i<nhaphangform.table.getRowCount();i++) {
			String sl=model.getValueAt(i,3).toString();
			String dg=model.getValueAt(i,5).toString();
					sum+=Integer.parseInt(dg)*Integer.parseInt(sl);	

		}
		nhaphangform.tongtien.setText(sum+"");
	}
	public static void them() {
		String dv;
		if(nhaphangform.dv.getSelectedItem()==null)
			dv="";
		else 
			dv=nhaphangform.dv.getSelectedItem().toString().trim();
		String ngay;
		Date today=new Date();
		if(nhaphangform.date.getDate()==null||nhaphangform.date.getDate().compareTo(today)<=0)
		{	
			ngay="";
		}
		else
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			ngay = dateFormat.format(nhaphangform.date.getDate());  
		}
		String thuoc=nhaphangform.mathuoc.getText().trim();
		String hang=nhaphangform.hang.getText().trim();
		String sl=nhaphangform.sl.getValue().toString();
		String dg=nhaphangform.dongia.getText();
		if(sl.trim().equals("0")||thuoc.equals("")||hang.equals("")||dv.equals("")||dg.equals("")||ngay.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Vui lòng nhập thông tin chính xác");
			return;
		}
		DefaultTableModel model=(DefaultTableModel) nhaphangform.table.getModel();
		for(int i=0;i<nhaphangform.table.getRowCount();i++)
		{
			if(model.getValueAt(i,0).toString().equals(thuoc)&&model.getValueAt(i,1).toString().equals(hang)&&model.getValueAt(i,2).toString().equals(dv)) {
				int temp=Integer.parseInt(sl)+Integer.parseInt(model.getValueAt(i,3).toString());
				model.setValueAt(temp+"",i,3);
				nhaphangform.table.setModel(model);
				tinhtien();
				return;
			}
		}
		model.addRow(new Object[] {thuoc,hang,dv,Integer.parseInt(sl),ngay,Integer.parseInt(dg)});
		nhaphangform.table.setModel(model);
		tinhtien();
	}
	public static void xoa() {
		int i=nhaphangform.table.getSelectedRow();
		if(i<0) {
			JOptionPane.showMessageDialog(null,"Vui lòng chọn hàng cần xóa");
			tinhtien();
			return;
		}
		DefaultTableModel model= (DefaultTableModel) nhaphangform.table.getModel();
		model.removeRow(i);
		nhaphangform.table.setModel(model);
		tinhtien();
	}
	public static void nhap() {
		if(nhaphangform.maphieu.getText().trim().equals("")) {	
			JOptionPane.showMessageDialog(null,"Vui lòng nhập mã phiếu");
			return;
		}
		if(nhaphangform.nhacungcap.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null,"Vui lòng nhập nhà cung cấp");
			return;
		}
		boolean flag=false;
		for(nhacungcap a:Mainframe.listcc.list) {
			if(a.getMa().trim().equals(nhaphangform.nhacungcap.getText().trim())) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			JOptionPane.showMessageDialog(null,"Nhà cung cấp này không tồn tại");
			return;
		}
		DefaultTableModel model= (DefaultTableModel)nhaphangform.table.getModel();
		if(nhaphangform.table.getRowCount()<1) {
			JOptionPane.showMessageDialog(null,"Vui lòng cung câp đầy đủ sản phẩm");
			return;
		}
		ArrayList<chitiet> list =new ArrayList<chitiet>();
		for(int i=0;i<nhaphangform.table.getRowCount();i++) {
			int sl=Integer.parseInt(model.getValueAt(i, 3).toString());
			int dg=Integer.parseInt(model.getValueAt(i,5).toString());
			Date d1=null;
		      try {
		    	  SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
				d1 = sdformat.parse(model.getValueAt(i,4).toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(id b:Mainframe.listdv.list)
			{
				if(b.getTen().trim().equals(model.getValueAt(i,2).toString().trim())) {
					list.add(new chitiet(model.getValueAt(i,0).toString().trim(),model.getValueAt(i,1).toString().trim(),b.getId(), sl, d1, dg));
				}
			}
			}	
		thongtinphieu temp=new thongtinphieu(nhaphangform.maphieu.getText().trim(),new Date(),nhaphangform.nhacungcap.getText().trim(), Mainframe.user, 0, list);
		temp.nhap();
		Mainframe.kho.load();
		Mainframe.listp.load();
		dsnhaphangcontrol.newtable();
		baocaocontrol.baocao();
		
	}

}
