import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;



	public class AudioConverter extends JFrame implements ActionListener {

		private  File filepathchosen;
		
		private JButton button = new JButton("Select File");
		private JButton button2 = new JButton("Exit");
		private JFileChooser fc = new JFileChooser();
		private JTextField Tfield = new JTextField("Choose the file: \n");
		
		
		 
		
		
		public AudioConverter()
		{
			
			this.setLayout(new FlowLayout());
			button.addActionListener(this);
			button.setFocusable(false);
			button2.addActionListener(this);
			button2.setFocusable(false);
			this.Tfield.setEditable(false);
		    this.add(Tfield);
			this.add(button);
			this.add(button2);
			this.pack();
			this.setVisible(true);
			this.setTitle(".aiif to .wav converter");
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		}
		
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(arg0.getSource()== button)
			{
			
				
				int response =fc.showOpenDialog(null);
				if(response == JFileChooser.APPROVE_OPTION) {
					this.filepathchosen = new File(fc.getSelectedFile().getAbsolutePath()); 
					
					System.out.println("The chosen path is: "+filepathchosen.getAbsolutePath()+"\n");
					try {
						
			            // Set the input and output files
			            String inputFileString = filepathchosen.getAbsolutePath();
			            String modifiedString = inputFileString.substring(0, inputFileString.length() - 4);
			            
			            modifiedString += "wav"; 
			            String outputFileString = modifiedString;
			            File inputFile = new File(inputFileString);
			            File outputFile = new File(outputFileString);
			            
			         // Get an audio input stream
			            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputFile);

			            // Get the format of the audio file (AIFF format in this case)
			            AudioFormat format = audioInputStream.getFormat();

			            // Convert it to WAV format (if possible)
			            AudioInputStream convertedStream = AudioSystem.getAudioInputStream(AudioFormat.Encoding.PCM_SIGNED, audioInputStream);

			            // Write the converted audio stream to a WAV file
			            AudioSystem.write(convertedStream, AudioFileFormat.Type.WAVE, outputFile);
			            System.out.println("Conversion completed!");
			        } catch (IOException e) {
			            e.printStackTrace();
			        } catch (UnsupportedAudioFileException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			
		}

			
			
			if(arg0.getSource()== button2)
			{
			this.dispose();
			}
	}
	}
			
	



