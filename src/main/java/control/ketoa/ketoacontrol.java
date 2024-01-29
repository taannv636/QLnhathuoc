package control.ketoa;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Templates;

import control.baocaocontrol;
import form.ketoa.ketoaform;
import form.ketoa.tabketoa;
import form.main.Mainframe;
import model.thuoc.id;
import model.thuoc.lothuoc;
import model.thuoc.thuoc;
import model.toathuoc.chitiet;
import model.toathuoc.thongtintoa;
import model.user.duocsi;

public class ketoacontrol {

	public static void back() {
		tabketoa.tabbedPane.setSelectedIndex(0);
	}
	public static void newtable() {
		DefaultTableModel model =new DefaultTableModel(new Object[][] {},
				new String[] { "Mã thuốc","Hãng","Mã lô thuốc","Đơn vị", "Số lượng","Ghi chú"}) {
			boolean[] columnEditables = new boolean[] { false, false,false, false ,false,false};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		ketoaform.table.setModel(model);
		ketoaform.table.getTableHeader().setReorderingAllowed(false);
		tinhtien();
	}
	
	public static void them() {
		String lo;
		if(ketoaform.lo.getSelectedItem()==null)
			lo="";
		else
			lo=ketoaform.lo.getSelectedItem().toString().trim();	
		
		String dv;
		if(ketoaform.dv.getSelectedItem()==null)
			dv="";
		else 
			dv=ketoaform.dv.getSelectedItem().toString().trim();
		
		String thuoc=ketoaform.mathuoc.getText().trim();
		String hang=ketoaform.mahang.getText().trim();
		String sl=ketoaform.sl.getValue().toString();
		String gc=ketoaform.gc.getText().trim();
		if(sl.trim().equals("0")||thuoc.equals("")||hang.equals("")||dv.equals("")||lo.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
			return;
		}
		for(thuoc a:Mainframe.kho.listthuoc) {
			if(a.getMathuoc().trim().equals(thuoc)&&a.getHangthuoc().trim().equals(hang)&&a.getDonvi().getTen().trim().equals(dv)){
				for(lothuoc b:a.getLohang()) {
					if(b.getMalothuoc().trim().equals(lo)) {
						if(b.getHansudung().compareTo(new Date())<=0)
						{
							JOptionPane.showMessageDialog(null,"Lô thuốc này đã hết hạn sử dụng");
							return;
						}
						break;
					}
				}
			}
		}
		
		DefaultTableModel model=(DefaultTableModel) ketoaform.table.getModel();
		for(int i=0;i<ketoaform.table.getRowCount();i++) {
			if(model.getValueAt(i,0).toString().trim().equals(thuoc)&&model.getValueAt(i,3).toString().trim().equals(dv)&&model.getValueAt(i,1).toString().trim().equals(hang)&&model.getValueAt(i,2).toString().trim().equals(lo)) {
				int temp=Integer.parseInt(sl)+Integer.parseInt(model.getValueAt(i,4).toString());
				model.setValueAt(temp+"",i,4);
				ketoaform.table.setModel(model);
				tinhtien();
				return;
			}
		}
		model.addRow(new Object[] {thuoc,hang,lo,dv,Integer.parseInt(sl),gc});
		ketoaform.table.setModel(model);
		tinhtien();
	}
	
	public static void checkdv() {
	String thuoc=ketoaform.mathuoc.getText().trim();
	String hang=ketoaform.mahang.getText().trim();
	DefaultComboBoxModel model=new DefaultComboBoxModel();
	for(thuoc a:Mainframe.kho.listthuoc) {
		if(a.getMathuoc().trim().equals(thuoc)&&a.getHangthuoc().trim().equals(hang)){
			model.addElement(a.getDonvi().getTen());
		}
	}	
	ketoaform.dv.setModel(model);
	if(model.getSize()>0) 
		ketoaform.dv.setEnabled(true);	
	else 
		ketoaform.dv.setEnabled(false);
	checklo();
	}
	public static void checklo() {
		String dv;
		if(ketoaform.dv.getSelectedItem()==null)
		{
			dv="";
		}
		else {
			dv=ketoaform.dv.getSelectedItem().toString().trim();
		}
		String thuoc=ketoaform.mathuoc.getText().trim();
		String hang=ketoaform.mahang.getText().trim();
		
		DefaultComboBoxModel model=new DefaultComboBoxModel();
		for(thuoc a:Mainframe.kho.listthuoc) {
				if(a.getMathuoc().trim().equals(thuoc)&&a.getHangthuoc().trim().equals(hang)&&a.getDonvi().getTen().trim().equals(dv)){
					for(lothuoc b:a.getLohang()) {
						model.addElement(b.getMalothuoc());
					}
				}
			}
		ketoaform.lo.setModel(model);
		if(model.getSize()>0) 
			ketoaform.lo.setEnabled(true);	
		else 
			ketoaform.lo.setEnabled(false);
		setmaxsl();
		}
	public static void setmaxsl() {
		ketoaform.sl.setModel(new SpinnerNumberModel(0, 0,0, 1));
		String lo;
		if(ketoaform.lo.getSelectedItem()==null)
		{
			lo="";
		}
		else {
			lo=ketoaform.lo.getSelectedItem().toString().trim();
		}
		String dv;
		if(ketoaform.dv.getSelectedItem()==null)
		{
			dv="";
		}
		else {
			dv=ketoaform.dv.getSelectedItem().toString().trim();
		}
		ketoaform.sl.setEnabled(false);
		String thuoc=ketoaform.mathuoc.getText().trim();
		String hang=ketoaform.mahang.getText().trim();
		for(thuoc a:Mainframe.kho.listthuoc) {
			if(a.getMathuoc().trim().equals(thuoc)&&a.getHangthuoc().trim().equals(hang)&&a.getDonvi().getTen().trim().equals(dv)){
			
				for(lothuoc b:a.getLohang()) {

					 if(b.getMalothuoc().trim().equals(lo)) {
		
						 ketoaform.sl.setEnabled(true);
						 ketoaform.sl.setModel(new SpinnerNumberModel(0, 0, b.getSl(), 1));
						 return;
					 }
				}
			}
		}
	}
	public static void xoa() {
		int i=ketoaform.table.getSelectedRow();
		if(i<0) {
			JOptionPane.showMessageDialog(null,"Vui lòng chọn hàng cần xóa");
			tinhtien();
			return;
		}
		DefaultTableModel model= (DefaultTableModel) ketoaform.table.getModel();
		model.removeRow(i);
		ketoaform.table.setModel(model);
		tinhtien();
	}
	public static void tinhtien() {
		int sum=0;		
		DefaultTableModel model= (DefaultTableModel)ketoaform.table.getModel();
		for(int i=0;i<ketoaform.table.getRowCount();i++) {
			String thuoc=model.getValueAt(i,0).toString();
			String hang=model.getValueAt(i,1).toString();
			String sl=model.getValueAt(i,4).toString();
			String dv=model.getValueAt(i,3).toString();
			for(thuoc a:Mainframe.kho.listthuoc) {
				if(a.getMathuoc().trim().equals(thuoc)&&a.getHangthuoc().trim().equals(hang)&&a.getDonvi().getTen().trim().equals(dv)) {
					sum+=a.getGiaban()*Integer.parseInt(sl);
					System.out.println();
					break;
				}
			}
		}
		ketoaform.tongtien.setText(sum+"");
	}
	public static void thanhtoan() {
		if(ketoaform.matoa.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null,"Vui lòng nhập mã toa");
			return;
		}
		DefaultTableModel model= (DefaultTableModel)ketoaform.table.getModel();
		if(ketoaform.table.getRowCount()<1) {
			JOptionPane.showMessageDialog(null,"Vui lòng kê thuốc");
			return;
		}
		ArrayList<chitiet> list=new ArrayList<chitiet>();
		for(int i=0;i<ketoaform.table.getRowCount();i++) {
			int sl=Integer.parseInt(model.getValueAt(i, 4).toString());
			for(id b:Mainframe.listdv.list)
			{
				if(b.getTen().trim().equals(model.getValueAt(i, 3).toString().trim())) {
					list.add(new chitiet(model.getValueAt(i, 0).toString(),model.getValueAt(i, 1).toString(),b.getId(), sl, model.getValueAt(i, 5).toString(), model.getValueAt(i, 2).toString()));

				}
			}
			}		
		thongtintoa temp=new thongtintoa(ketoaform.matoa.getText(),new Date(),(duocsi) Mainframe.user,Integer.parseInt( ketoaform.tongtien.getText()), list);
		temp.nhap();		
		Mainframe.kho.load();
		Mainframe.listt.load();
		dstoacontrol.newtable();
		baocaocontrol.baocao();
	}
	
}
