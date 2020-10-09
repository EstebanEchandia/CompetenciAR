package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PantallaIniciarSesion extends JPanel{

private GridBagConstraints gbc;
private JPanel tpPanel;
	
public PantallaIniciarSesion(JPanel tp) {
	this.tpPanel = tp;
	this.armarApp();
}

	public void armarApp() {
		this.gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		
		ImageIcon iconoVolver= new ImageIcon("IconoVolver.JPG");
		
		JLabel ingresarUsuario = new JLabel("Usuario: ");
		JLabel ingresarContrase�a = new JLabel("Contrase�a: ");
		Font fuente =  new Font("fuentePantalla", ingresarContrase�a.getFont().getStyle(), 35);
		ingresarUsuario.setFont(fuente);
		ingresarContrase�a.setFont(fuente);
		
		
		final JTextField usuario = new JTextField();
		final JPasswordField contrase�a = new JPasswordField();
		
		usuario.setFont(fuente);
		contrase�a.setFont(fuente);
		
		usuario.setPreferredSize(new Dimension(550,50));
		usuario.setMinimumSize(new Dimension(550, 50));
		usuario.setMaximumSize(new Dimension(550, 50));
		
		contrase�a.setPreferredSize(new Dimension(550, 50));
		contrase�a.setMinimumSize(new Dimension(550, 50));
		contrase�a.setMaximumSize(new Dimension(550, 50));
		
		JButton volver = new JButton();
		volver.setPreferredSize(new Dimension(33,33));
		volver.setIcon(iconoVolver);
		
		Border line = new LineBorder(Color.WHITE);
		Border margin = new EmptyBorder(0, 0, 0, 0);
		Border compound = new CompoundBorder(line, margin);
		volver.setBorder(compound);
		
		volver.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout layout = (CardLayout)tpPanel.getLayout();
		        layout.show(tpPanel, "Card__UsuarionNoAutenticado");
			}
			
		});
		
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.setFont(fuente);
		aceptar.setBackground(Color.GRAY);
		aceptar.setPreferredSize(new Dimension(200,50));
		aceptar.setMinimumSize(new Dimension(200, 50));
		aceptar.setMaximumSize(new Dimension(200, 50));
		
		aceptar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (usuario.getText().isBlank()) {
					JOptionPane.showMessageDialog(new JPanel(),"Debe ingresar un usuario", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(contrase�a.getPassword().length == 0) {
					JOptionPane.showMessageDialog(new JPanel(),"Debe ingresar una contrase�a", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String usuarioIngresado = usuario.getText();
					char[] contrase�aIngresada = contrase�a.getPassword();
					//verificarUsuario
					CardLayout layout = (CardLayout)tpPanel.getLayout();
			        layout.show(tpPanel, "Card__UsuarioAutenticado");
				}
			}
		});
		
		JButton filler = new JButton ();
		filler.setBorder(compound);
		filler.setEnabled(false);
		filler.setBackground(Color.WHITE);
		filler.setPreferredSize(new Dimension(117,20));
		filler.setMinimumSize(new Dimension(117, 20));
		filler.setMaximumSize(new Dimension(117, 20));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		this.add(volver,gbc);
		

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		this.add(Box.createRigidArea(new Dimension(117,20)),gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.anchor=GridBagConstraints.EAST;
		this.add(ingresarUsuario,gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.anchor=GridBagConstraints.CENTER;
		this.add(usuario,gbc);
		
	
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth=1;
		gbc.gridheight=1;

		this.add(Box.createRigidArea(new Dimension(117,10)),gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		this.add(ingresarContrase�a,gbc);
	
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		this.add(contrase�a,gbc);
		
		
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.gridwidth=1;
		gbc.gridheight=1;

		this.add(Box.createRigidArea(new Dimension(117,20)),gbc);
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.gridwidth=1;
		gbc.gridheight=1;
		gbc.anchor=GridBagConstraints.EAST;
		//gbc.weightx=0.1;

		this.add(aceptar,gbc);
	}
	
}
