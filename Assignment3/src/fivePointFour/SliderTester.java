package fivePointFour;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.event.*;
import javax.swing.*;
public class SliderTester {
	private static final int widthOfFrame = 300;
	private static final int heightOfFrame = 300;
	private static final int SliderMinSize = 0;
	private static final int SliderMaxSize = widthOfFrame;
	private static CarIcon car;
	private static JLabel label;
	private static JSlider slider_zoom;
	public static void main(String[] args)
	{
		JFrame fr = new JFrame();
		fr.setSize(widthOfFrame, heightOfFrame);
		Container contentPane = fr.getContentPane();
		fr.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		slider_zoom = new JSlider(SliderMinSize, SliderMaxSize);
		slider_zoom.addChangeListener(createZoomSliderListener());
		car = new CarIcon(SliderMaxSize);
		label = new JLabel(car);
		fr.add(slider_zoom);
		fr.add(label);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		car.setIconWidth(slider_zoom.getValue());
		fr.setVisible(true);
	}

	public static ChangeListener createZoomSliderListener(){
		return new ChangeListener(){
			public void stateChanged(ChangeEvent event){
				car.setIconWidth(slider_zoom.getValue());
				label.repaint();
			}
		};
	}
}

