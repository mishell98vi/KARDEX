/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kardex.vistas;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import kardex.negocio.dao.*;
import kardex.negocio.impl.*;
import kardex.negocio.entidades.*;
import java.awt.Color;
public class Form_Proveedor extends JFrame {
    JLabel ruc;
    JLabel nombre;
    JLabel direccion;
    JLabel telefono;
    JLabel eMail;
   
    JTextField txtruc;
    JTextField txtnombre;
    JTextField txtdireccion;
    JTextField txttelefono;
    JTextField txtEmail;
    

    JButton btnLimpiar;
    JButton btnAceptar;
    JButton btnCancelar;
   
    JPanel pnlcentral;
    JPanel pnlpie;

    public Form_Proveedor() {
        this.setSize(300, 300);
        
        setTitle("  PROVEEDOR....");
      //  this.setClosable(true);
        
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(5, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        
        ruc = new JLabel("    RUC:  ");  
        nombre= new JLabel("    NOMBRE:");
        direccion= new JLabel("    DIRECCION:");
        telefono= new JLabel("    TELEFONO:");
        eMail= new JLabel("    EMAIL:");
        
        
         txtruc= new JTextField(2);
         txtnombre= new JTextField(2);
         txtdireccion= new JTextField(2);
         txttelefono= new JTextField(2);
         txtEmail= new JTextField(2);
         
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        btnCancelar = new JButton("CANCELAR");
        
        
        pnlcentral.setBackground(Color.CYAN);
        
  
        pnlcentral.add(ruc);
        pnlcentral.add(txtruc);
        pnlcentral.add(nombre);
        pnlcentral.add(txtnombre);
        pnlcentral.add(direccion);
        pnlcentral.add(txtdireccion);
        pnlcentral.add(telefono);
        pnlcentral.add(txttelefono);
        pnlcentral.add(eMail);
        pnlcentral.add(txtEmail);
        
        
        pnlpie.add(btnLimpiar);
        pnlpie.add(btnAceptar);
        pnlpie.add(btnCancelar);
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
       
 
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);

        
    }
    
      public static void main(String[] args) {
        Form_Proveedor formP = new Form_Proveedor();
        formP.setVisible(true);   
    }
    public void btnAceptarActionListener(ActionEvent e){
        
            ProveedorI proveedorDao=new ProveedorImp();
            Proveedor proveedor = new Proveedor();
            
            proveedor.setRuc(txtruc.getText());
            proveedor.setNombre(txtnombre.getText());
            proveedor.setDireccion(txtdireccion.getText());
            proveedor.setTelefono(txttelefono.getText());
            proveedor.setEmail(txtEmail.getText());
        
          try{
            if(proveedorDao.ingresar(proveedor)>0){
                JOptionPane.showMessageDialog(this,"Guardado con exito",
                "transaccion", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido",
                "error", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception ex){
             JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
