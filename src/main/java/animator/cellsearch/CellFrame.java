package animator.cellsearch;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import static SpriteManipulator.SpriteManipulator.SPRITE_SHEET_HEIGHT;
import static SpriteManipulator.SpriteManipulator.SPRITE_SHEET_WIDTH;

public class CellFrame extends JDialog {
	private static final long serialVersionUID = 2205482111878391757L;

	public static final int ZOOM = 2;
	private static final Dimension D =
			new Dimension(SPRITE_SHEET_WIDTH * ZOOM + 200 + 50 * ZOOM, SPRITE_SHEET_HEIGHT * ZOOM + 50);

	private CellLister lister;
	public CellFrame(JFrame f) {
		super(f);
		initialize();
		this.setResizable(false);
		this.setTitle("Sheet trawler");
	}

	private final void initialize() {
		this.setPreferredSize(D);
		this.setMaximumSize(D);
		this.setMinimumSize(D);

		SpringLayout l = new SpringLayout();
		this.setLayout(l);

		// sheet controls
		lister = new CellLister();
		l.putConstraint(SpringLayout.NORTH, lister, 5,
				SpringLayout.NORTH, this);
		l.putConstraint(SpringLayout.WEST, lister, 5,
				SpringLayout.WEST, this);
		this.add(lister);

		// image shown
		JComboBox<SheetOption> sheet = new JComboBox<SheetOption>(SheetOption.values());
		l.putConstraint(SpringLayout.NORTH, sheet, 5,
				SpringLayout.NORTH, this);
		l.putConstraint(SpringLayout.EAST, sheet, -15,
				SpringLayout.EAST, this);
		this.add(sheet);

		// unused frames
		JCheckBox showUnused = new JCheckBox("Hide unused sprites");
		l.putConstraint(SpringLayout.NORTH, showUnused , 5,
				SpringLayout.SOUTH, sheet);
		l.putConstraint(SpringLayout.EAST, showUnused , 0,
				SpringLayout.EAST, sheet);
		this.add(showUnused);

		JLabel info = new JLabel("Step counts are with all sprites visible.");
		l.putConstraint(SpringLayout.SOUTH, info, 0,
				SpringLayout.SOUTH, lister);
		l.putConstraint(SpringLayout.WEST, info, 15,
				SpringLayout.EAST, lister);
		l.putConstraint(SpringLayout.EAST,  info, 0,
				SpringLayout.EAST, sheet);
		this.add(info);

		// text for frames
		@SuppressWarnings("serial")
		JLabel listed = new JLabel("") {
			public void setText(String t) {
				super.setText("<html><div style=\"padding:4px; max-width:200px\">" + t + "</div></html>");
			}
		};

		listed.setVerticalAlignment(SwingConstants.NORTH);

		JScrollPane list = new JScrollPane(listed,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		l.putConstraint(SpringLayout.NORTH, list, 5,
				SpringLayout.SOUTH, showUnused );
		l.putConstraint(SpringLayout.SOUTH, list, -5,
				SpringLayout.NORTH,  info);
		l.putConstraint(SpringLayout.WEST, list, 15,
				SpringLayout.EAST, lister);
		l.putConstraint(SpringLayout.EAST, list, 0,
				SpringLayout.EAST, sheet);
		this.add(list);

		sheet.addItemListener(
			arg0 -> {
				lister.setOption((SheetOption) arg0.getItem());
			});

		lister.addActionListener(
				arg0 -> {
					SpriteBlock b = (SpriteBlock) arg0.getSource();
					listed.setText(b.cell.HTMLret);
					repaint();
				});

		showUnused.addChangeListener(
				arg0 -> {
					lister.setHideUnused(showUnused.isSelected());
				});
		showUnused.setSelected(true);
	}

	public void setSprite(BufferedImage i) {
		lister.setSprite(i);
		repaint();
	}
}