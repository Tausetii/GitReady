package Module5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentClassFrame extends JFrame{
    
    JPanel studentPanel, classPanel;
    JLabel lblName, lblClass, lblLanguage, lblGender;
    JTextField txtName;
    JRadioButton rdoMath, rdoScience, rdoSpanish, rdoEnglish, rdoMale, rdoFemale;
    JButton btnSubmit;
    DefaultListModel<String> studentListModel;
    JList<String> studentList;
    
    public StudentClassFrame() {
        setTitle("Student and Class Information");
        setSize(1200,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        studentPanel = new JPanel();
        studentPanel.setLayout(new FlowLayout());
        
        lblName = new JLabel("Student Name:");
        txtName = new JTextField(20);
        btnSubmit = new JButton("Submit");
        
        studentPanel.add(lblName);
        studentPanel.add(txtName);
        studentPanel.add(btnSubmit);
        
        classPanel = new JPanel();
        classPanel.setLayout(new FlowLayout());
        
        lblClass = new JLabel("Select Class:");
        rdoMath = new JRadioButton("Math");
        rdoScience = new JRadioButton("Science");
        
        lblLanguage = new JLabel("Select Language:");
        rdoEnglish = new JRadioButton("English");
        rdoSpanish = new JRadioButton("Spanish");
        
        lblGender = new JLabel("Select Gender:");
        rdoMale = new JRadioButton("Male");
        rdoFemale = new JRadioButton("Female");
        
        ButtonGroup classButtonGroup = new ButtonGroup();
        classButtonGroup.add(rdoMath);
        classButtonGroup.add(rdoScience);
        
        ButtonGroup languageButtonGroup = new ButtonGroup();
        languageButtonGroup.add(rdoEnglish);
        languageButtonGroup.add(rdoSpanish);
        
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(rdoMale);
        genderButtonGroup.add(rdoFemale);
        
        classPanel.add(lblClass);
        classPanel.add(rdoMath);
        classPanel.add(rdoScience);
        
        classPanel.add(lblLanguage);
        classPanel.add(rdoEnglish);
        classPanel.add(rdoSpanish);
        
        classPanel.add(lblGender);
        classPanel.add(rdoMale);
        classPanel.add(rdoFemale);
        
        studentListModel = new DefaultListModel<>();
        studentList = new JList<>(studentListModel);
        
        setLayout(new GridLayout(2,1));
        add(studentPanel);
        add(classPanel);
        add(new JScrollPane(studentList));
        
        btnSubmit.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                String studentName = txtName.getText();
                String selectedClass = "";
                String selectedLanguage = "";
                String selectedGender = "";
                
                if(rdoMath.isSelected())
                {
                    selectedClass = "Math";
                }
                
                else if(rdoScience.isSelected())
                {
                    selectedClass = "Science";
                }
                
                if(rdoEnglish.isSelected())
                {
                    selectedLanguage = "English";
                }
                
                else if(rdoScience.isSelected())
                {
                    selectedLanguage = "Spanish";
                }
                
                if(rdoMale.isSelected())
                {
                    selectedGender = "Male";
                }
                
                else if(rdoFemale.isSelected())
                {
                    selectedGender = "Female";
                }
                String studentInfo = "Student Name: "+  studentName + " - Class: " + selectedClass
                         + " - Language: " + selectedLanguage + " - Gender: " + selectedGender;
                
                studentListModel.addElement(studentInfo);
                txtName.setText("");
                rdoMath.setSelected(true);
            }
        });
        
    }
    
    public static void main(String[] args) {
        StudentClassFrame frame = new StudentClassFrame();
        frame.setVisible(true);
    }
}
