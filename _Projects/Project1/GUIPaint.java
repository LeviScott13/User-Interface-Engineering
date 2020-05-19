import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class GUIPaint extends JFrame implements MouseListener,ItemListener,ActionListener,MouseMotionListener {

    JPanel panel;
    JComboBox shapes;
    JRadioButton RED, BLUE;
    JComboBox line_thicknesses;
    JButton clear;
    JPanel center;
    Color color;
   
    int thickness;
    String shape;
    int start_X, start_Y, end_X, end_Y;
    boolean start;

    String shapes_List[] = { "Line", "Rectangle", "Oval" };
    String line_thicknessList[] = { "3", "6", "9"};

    GUIPaint() {

        setSize(800, 600);
        setLayout(new BorderLayout());

        panel = new JPanel(new FlowLayout());

        JLabel shape_Label = new JLabel("Shape: ");
        JLabel color_Label = new JLabel("Color: ");
        JLabel thickness_Label = new JLabel("Thickness: ");
        
        shapes = new JComboBox(shapes_List);

        RED = new JRadioButton("Red");
        BLUE = new JRadioButton("Blue");

        ButtonGroup buttons = new ButtonGroup();

        buttons.add(RED);
        buttons.add(BLUE);

        line_thicknesses = new JComboBox(line_thicknessList);

        clear = new JButton("Clear");
        center = new JPanel();

        panel.add(shape_Label);
        panel.add(shapes);
        panel.add(color_Label);
        panel.add(RED);
        panel.add(BLUE);
        panel.add(thickness_Label);
        panel.add(line_thicknesses);
        panel.add(clear);

        add(panel, BorderLayout.NORTH);
        add(center,BorderLayout.CENTER);

        addMouseListener(this);
        RED.addItemListener(this);
        BLUE.addItemListener(this);
        shapes.addActionListener(this);
        clear.addActionListener(this);
        line_thicknesses.addActionListener(this);

        color = Color.RED;
        RED.setSelected(true);
        thickness = 3;
        shape = "Line";
        start = false;
}

    public void actionPerformed(ActionEvent ae1)
    {

        if(ae1.getSource() == shapes)
        {
            shape = ""+shapes.getItemAt(shapes.getSelectedIndex());
        }
        else if(ae1.getSource() == clear)
        {

            repaint();
        }
       else if(ae1.getSource() == line_thicknesses)
       {
           try
           {
                thickness = Integer.parseInt(""+line_thicknesses.getItemAt(line_thicknesses.getSelectedIndex()));
           }
           catch(Exception e)
           {
               thickness = 3;
           }
       }
   }

   public void itemStateChanged(ItemEvent ie1)
   {
       if(ie1.getSource() == RED)
       {
           color = Color.RED;
       }
       else if(ie1.getSource() == BLUE)
       {
           color = Color.BLUE;
       }
   }
   
   public void mousePressed(MouseEvent e)
   {
       if(start == false)
       {
            start_X = e.getX();
            start_Y = e.getY();
            start = true;
        }
   }

   public void mouseReleased(MouseEvent e)
   {
      if(start)
       {
           end_X = e.getX();
           end_Y = e.getY();
           start = false;
           draw();
       }
   }

   public void check_Distance()
   {
       if(start_X > end_X)
       {
           int temp = start_X;
           start_X = end_X;
           end_X = temp;
      }
       if(start_Y > end_Y)
       {
           int temp = start_Y;
           start_Y = end_Y;
           end_Y = temp;
       }
   }

   public void draw()
   {
       Graphics2D drawGraphic = (Graphics2D) getGraphics();

       drawGraphic.setStroke(new BasicStroke(thickness));
       drawGraphic.setColor(color);

       int width = Math.abs(end_X-start_X);
       int height = Math.abs(end_Y-start_Y);

        if(shape.equals(("Rectangle")))
        {
            check_Distance();
            drawGraphic.fillRect(start_X,start_Y,width,height);
        }
        else if(shape.equals("Oval"))
        {
            check_Distance();
            drawGraphic.fillOval(start_X,start_Y,width,height);
        }
        else
        {
           drawGraphic.drawLine(start_X, start_Y, end_X, end_Y);
        }

    }
    public void mouseExited(MouseEvent e)
    {    

    }
    public void mouseEntered(MouseEvent e)
    {

    }

    public void mouseClicked(MouseEvent e)
    {

    }

    public void mouseDragged(MouseEvent e)
    {

    }

    public void mouseMoved(MouseEvent e)

    {

    }
    public static void main(String[] args) {

       GUIPaint frame1 = new GUIPaint();

       frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame1.setVisible(true);
       frame1.setResizable(false);
       frame1.setTitle("GUI Paint");
    }
}