package controller;

import GUI.Manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ManagerControl implements MouseListener{

	private Manager manager;
	
	public ManagerControl(Manager manager) {
		this.manager = manager;
	}
	
	public Manager getManager() {
		return manager;
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == manager.getLblIconZoomOut()) {
			manager.ZoomOutMenu();
		}else if(e.getSource() == manager.getLblIconZoomIn()){
			manager.ZoomInMenu();
			
		}else if(e.getSource() == manager.getLblTourManager()){
			manager.getCardLayout().show(manager.getPnlMainContent(), "pnlTourContent");
		}else if(e.getSource() == manager.getLblCusManager()){
			manager.getCardLayout().show(manager.getPnlMainContent(), "pnlCusContent");
		}else if(e.getSource() == manager.getLblDesManager()){
			manager.getCardLayout().show(manager.getPnlMainContent(), "pnlDesContent");
		}else if(e.getSource() == manager.getLblBillManager()){
			manager.getCardLayout().show(manager.getPnlMainContent(), "pnlBillContent");
		}else if(e.getSource() == manager.getLblSerManager()){
			manager.getCardLayout().show(manager.getPnlMainContent(), "pnlSerContent");
		}else if(e.getSource() == manager.getLblHotelManager()){
			manager.getCardLayout().show(manager.getPnlMainContent(), "pnlHotelContent");
		}else if(e.getSource() == manager.getLblAccManager()){
			manager.getCardLayout().show(manager.getPnlMainContent(), "pnlAccContent");
		}else if(e.getSource() == manager.getLblStatistical()){
			manager.getCardLayout().show(manager.getPnlMainContent(), "pnlStatisticalContent");
		}else if(e.getSource() == manager.getLblExportExcel()){
			manager.getCardLayout().show(manager.getPnlMainContent(), "pnlExportExcelContent");
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == manager.getLblIconZoomIn()){
			manager.getPnlZoom().setBackground(new Color(187, 222, 251));	
		}else if(e.getSource() == manager.getLblIconZoomOut()) {
			manager.getPnlZoom().setBackground(new Color(187, 222, 251));
		}else if(e.getSource() == manager.getLblIconHome()) {
			manager.getPnlHome().setBackground(new Color(187, 222, 251));
		}else if(e.getSource() == manager.getLblIconSetting()) {
			manager.getPnlSetting().setBackground(new Color(187, 222, 251));
		}else if(e.getSource() == manager.getLblIconLogOut()) {
			manager.getPnlLogOut().setBackground(new Color(187, 222, 251));

		}else if(e.getSource() == manager.getLblTourManager()) {
			manager.getPnlTourManager().setBackground(new Color(187, 222, 251));
		}else if(e.getSource() == manager.getLblCusManager()){
			manager.getPnlCusManager().setBackground(new Color(187, 222, 251));	
		}else if(e.getSource() == manager.getLblDesManager()) {
			manager.getPnlDesManager().setBackground(new Color(187, 222, 251));
		}else if(e.getSource() == manager.getLblBillManager()){
			manager.getPnlBillManager().setBackground(new Color(187, 222, 251));
		}else if(e.getSource() == manager.getLblSerManager()) {
			manager.getPnlSerManager().setBackground(new Color(187, 222, 251));
		}else if(e.getSource() == manager.getLblHotelManager()){
			manager.getPnlHotelManager().setBackground(new Color(187, 222, 251));	
		}else if(e.getSource() == manager.getLblAccManager()){
			manager.getPnlAccManager().setBackground(new Color(187, 222, 251));	
		}else if(e.getSource() == manager.getLblStatistical()) {
			manager.getPnlStatistical().setBackground(new Color(187, 222, 251));
		}else if(e.getSource() == manager.getLblExportExcel()) {
			manager.getPnlExportExcel().setBackground(new Color(187, 222, 251));
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == manager.getLblIconZoomIn()){
			manager.getPnlZoom().setBackground(new Color(33, 150, 243));	
		}else if(e.getSource() == manager.getLblIconZoomOut()) {
			manager.getPnlZoom().setBackground(new Color(33, 150, 243));
		}else if(e.getSource() == manager.getLblIconHome()) {
			manager.getPnlHome().setBackground(new Color(33, 150, 243));
		}else if(e.getSource() == manager.getLblIconSetting()) {
			manager.getPnlSetting().setBackground(new Color(33, 150, 243));
		}else if(e.getSource() == manager.getLblIconLogOut()) {
			manager.getPnlLogOut().setBackground(new Color(33, 150, 243));
			
		}else if(e.getSource() == manager.getLblTourManager()) {
			manager.getPnlTourManager().setBackground(new Color(66, 165, 243));
		}else if(e.getSource() == manager.getLblCusManager()){
			manager.getPnlCusManager().setBackground(new Color(66, 165, 243));	
		}else if(e.getSource() == manager.getLblDesManager()) {
			manager.getPnlDesManager().setBackground(new Color(66, 165, 243));
		}else if(e.getSource() == manager.getLblBillManager()){
			manager.getPnlBillManager().setBackground(new Color(66, 165, 243));
		}else if(e.getSource() == manager.getLblSerManager()) {
			manager.getPnlSerManager().setBackground(new Color(66, 165, 243));
		}else if(e.getSource() == manager.getLblHotelManager()){
			manager.getPnlHotelManager().setBackground(new Color(66, 165, 243));	
		}else if(e.getSource() == manager.getLblAccManager()){
			manager.getPnlAccManager().setBackground(new Color(66, 165, 243));	
		}else if(e.getSource() == manager.getLblStatistical()) {
			manager.getPnlStatistical().setBackground(new Color(66, 165, 243));
		}else if(e.getSource() == manager.getLblExportExcel()) {
			manager.getPnlExportExcel().setBackground(new Color(66, 165, 243));
		}		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == manager.getLblIconZoomIn()){
			manager.getPnlZoom().setBackground(new Color(144, 202, 249));	
		}else if(e.getSource() == manager.getLblIconZoomOut()) {
			manager.getPnlZoom().setBackground(new Color(144, 202, 249));
		}else if(e.getSource() == manager.getLblIconHome()) {
			manager.getPnlHome().setBackground(new Color(144, 202, 249));
		}else if(e.getSource() == manager.getLblIconSetting()) {
			manager.getPnlSetting().setBackground(new Color(144, 202, 249));
		}else if(e.getSource() == manager.getLblIconLogOut()) {
			manager.getPnlLogOut().setBackground(new Color(144, 202, 249));
		
		}else if(e.getSource() == manager.getLblTourManager()) {
			manager.getPnlTourManager().setBackground(new Color(144, 202, 249));
		}else if(e.getSource() == manager.getLblCusManager()){
			manager.getPnlCusManager().setBackground(new Color(144, 202, 249));	
		}else if(e.getSource() == manager.getLblDesManager()) {
			manager.getPnlDesManager().setBackground(new Color(144, 202, 249));
		}else if(e.getSource() == manager.getLblBillManager()){
			manager.getPnlBillManager().setBackground(new Color(144, 202, 249));
		}else if(e.getSource() == manager.getLblSerManager()) {
			manager.getPnlSerManager().setBackground(new Color(144, 202, 249));
		}else if(e.getSource() == manager.getLblHotelManager()){
			manager.getPnlHotelManager().setBackground(new Color(144, 202, 249));	
		}else if(e.getSource() == manager.getLblAccManager()){
			manager.getPnlAccManager().setBackground(new Color(144, 202, 249));	
		}else if(e.getSource() == manager.getLblStatistical()) {
			manager.getPnlStatistical().setBackground(new Color(144, 202, 249));
		}else if(e.getSource() == manager.getLblExportExcel()) {
			manager.getPnlExportExcel().setBackground(new Color(144, 202, 249));
		}	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == manager.getLblIconZoomIn()){
			manager.getPnlZoom().setBackground(new Color(33, 150, 243));	
		}else if(e.getSource() == manager.getLblIconZoomOut()) {
			manager.getPnlZoom().setBackground(new Color(33, 150, 243));
		}else if(e.getSource() == manager.getLblIconHome()) {
			manager.getPnlHome().setBackground(new Color(33, 150, 243));
		}else if(e.getSource() == manager.getLblIconSetting()) {
			manager.getPnlSetting().setBackground(new Color(33, 150, 243));
		}else if(e.getSource() == manager.getLblIconLogOut()) {
			manager.getPnlLogOut().setBackground(new Color(33, 150, 243));
				
		}else if(e.getSource() == manager.getLblTourManager()) {
			manager.getPnlTourManager().setBackground(new Color(66, 165, 243));
		}else if(e.getSource() == manager.getLblCusManager()){
			manager.getPnlCusManager().setBackground(new Color(66, 165, 243));	
		}else if(e.getSource() == manager.getLblDesManager()) {
			manager.getPnlDesManager().setBackground(new Color(66, 165, 243));
		}else if(e.getSource() == manager.getLblBillManager()){
			manager.getPnlBillManager().setBackground(new Color(66, 165, 243));
		}else if(e.getSource() == manager.getLblSerManager()) {
			manager.getPnlSerManager().setBackground(new Color(66, 165, 243));
		}else if(e.getSource() == manager.getLblHotelManager()){
			manager.getPnlHotelManager().setBackground(new Color(66, 165, 243));	
		}else if(e.getSource() == manager.getLblAccManager()){
			manager.getPnlAccManager().setBackground(new Color(66, 165, 243));	
		}else if(e.getSource() == manager.getLblStatistical()) {
			manager.getPnlStatistical().setBackground(new Color(66, 165, 243));
		}else if(e.getSource() == manager.getLblExportExcel()) {
			manager.getPnlExportExcel().setBackground(new Color(66, 165, 243));
		}		
	}
	
}
