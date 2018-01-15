package animator.cellsearch;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import animator.PrettyBox;
import animator.database.Animation;
import animator.database.StepData;

import static spritemanipulator.SpriteManipulator.SPRITE_SHEET_HEIGHT;
import static spritemanipulator.SpriteManipulator.SPRITE_SHEET_WIDTH;
import static javax.swing.SpringLayout.*;

public class CellFrame extends JDialog {
	private static final long serialVersionUID = 2205482111878391757L;

	public static final int ZOOM = 2;
	private static final Dimension D =
			new Dimension(SPRITE_SHEET_WIDTH * ZOOM + 450 + 50 * ZOOM, SPRITE_SHEET_HEIGHT * ZOOM + 50);
	private static final Dimension D_SMALL =
			new Dimension(SPRITE_SHEET_WIDTH * ZOOM + 450 + 50 * ZOOM, SPRITE_SHEET_HEIGHT * 3 / 2);

	private CellLister lister;
	public CellFrame(JFrame f) {
		super(f);
		initialize();
		this.setResizable(false);
		this.setTitle("Sheet trawler");
	}

	private final void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int screenHeight = screenSize.height;
		boolean tooBig = screenHeight < (SPRITE_SHEET_HEIGHT * ZOOM - 50);
		Dimension curD = tooBig ? D_SMALL : D;

		this.setPreferredSize(curD);
		this.setMaximumSize(curD);
		this.setMinimumSize(curD);

		SpringLayout l = new SpringLayout();
		this.setLayout(l);

		// sheet controls
		lister = new CellLister();
		JScrollPane listScroll =
				new JScrollPane(lister,
						tooBig ? JScrollPane.VERTICAL_SCROLLBAR_ALWAYS : JScrollPane.VERTICAL_SCROLLBAR_NEVER,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		l.putConstraint(NORTH, listScroll, 5, NORTH, this);
		l.putConstraint(SOUTH, listScroll,
				tooBig ? (SPRITE_SHEET_HEIGHT * 3 / 2) - 50: SPRITE_SHEET_HEIGHT * ZOOM + 2,
				NORTH, listScroll);
		l.putConstraint(WEST, listScroll, 5, WEST, this);
		this.add(listScroll);

		// anim listed
		PrettyBox<Animation> anim = new PrettyBox<Animation>(Animation.values());
		l.putConstraint(NORTH, anim, 5, NORTH, this);
		l.putConstraint(EAST, anim, -15, EAST, this);
		this.add(anim);

		// sheet shown
		PrettyBox<SheetOption> sheet = new PrettyBox<SheetOption>(SheetOption.values());
		l.putConstraint(NORTH, sheet, 0, NORTH, anim);
		l.putConstraint(EAST, sheet, -90, WEST, anim);
		this.add(sheet);

		// mark cells
		JCheckBox markUsed = new JCheckBox("Mark cells used");
		l.putConstraint(NORTH, markUsed , 5, SOUTH, anim);
		l.putConstraint(EAST, markUsed , 0, EAST, anim);
		this.add(markUsed);

		// unused cells
		JCheckBox hideUnused = new JCheckBox("Mark unused cells");
		l.putConstraint(NORTH, hideUnused , 5, SOUTH, sheet);
		l.putConstraint(EAST, hideUnused , 0, EAST, sheet);
		this.add(hideUnused);

		JLabel info = new JLabel("Step counts are with all sprites visible.");
		l.putConstraint(SOUTH, info, 0, SOUTH, listScroll);
		l.putConstraint(WEST, info, 15, EAST, listScroll);
		l.putConstraint(EAST,  info, 0, EAST, sheet);
		this.add(info);

		// text for frames
		@SuppressWarnings("serial")
		JLabel listed = new JLabel("") {
			public void setText(String t) {
				super.setText("<html><div style=\"padding:0px; width:250px; word-wrap:normal;\">" + t + "</div></html>");
			}
		};

		listed.setVerticalAlignment(SwingConstants.NORTH);

		JScrollPane list = new JScrollPane(listed,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		l.putConstraint(NORTH, list, 5, SOUTH, hideUnused);
		l.putConstraint(SOUTH, list, -5, NORTH, info);
		l.putConstraint(WEST, list, 15, EAST, listScroll);
		l.putConstraint(EAST, list, 0, EAST, sheet);
		this.add(list);

		// text for cells used by animation
		@SuppressWarnings("serial")
		JLabel animUses = new JLabel("") {
			public void setText(String t) {
				super.setText("<html><div style=\"padding:0px; width:200px;\">" + t + "</div></html>");
			}
		};

		animUses.setVerticalAlignment(SwingConstants.NORTH);

		JScrollPane animUseList = new JScrollPane(animUses,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		l.putConstraint(NORTH, animUseList, 0, NORTH, list);
		l.putConstraint(SOUTH, animUseList, 0, SOUTH, list);
		l.putConstraint(WEST, animUseList, 15, EAST, list);
		l.putConstraint(EAST, animUseList, 0, EAST, anim);
		this.add(animUseList);

		anim.addItemListener(
			arg0 -> {
				Animation a = (Animation) arg0.getItem();
				lister.setAnimation(a);
				ArrayList<String> temp = new ArrayList<String>();
				int i = 1;

				for (StepData s : a.getSteps()) {
					temp.add("<div style=\"border:2px outset;");
					temp.add("padding-left:3px;");
					temp.add("font-weight:bold;");
					temp.add("background: #D8D8D8;\">");
					temp.add(Integer.toString(i++));
					temp.add("</div>");
					temp.add("<div style=\"margin-left:10px;");
					temp.add("font-family:consolas;");
					temp.add("margin-bottom: 5px;");
					temp.add("width: 200px;\">");
					temp.add(s.asList());
					temp.add("</div>");
				}
				animUses.setText(String.join("",temp));
			});

		anim.setSelectedIndex(4); // set index then set it back 
		anim.setSelectedIndex(0); // to force an event

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

		hideUnused.addChangeListener(
				arg0 -> {
					lister.setHideUnused(hideUnused.isSelected());
				});
		hideUnused.setSelected(true);

		markUsed.addChangeListener(
				arg0 -> {
					lister.setShowListed(markUsed.isSelected());
				});
		markUsed.setSelected(true);
	}

	public void setSprite(BufferedImage i) {
		lister.setSprite(i);
		repaint();
	}
}