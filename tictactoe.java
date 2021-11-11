import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import javax.swing.JFrame;
public class tictactoe extends Canvas implements MouseListener
{
	public void paint(Graphics g)
	{
		int vlx1=225,vlx2=375,vly1=90,vly2=540;
		//Here vl means vertical line,drawn from y1 to y2
		//x1 is for x-coordinate of vertical-line1,x2 is for x coordinate of vertical-line2
		int hlx1=75,hlx2=525,hly1=240,hly2=390;
		//Here hl means horizontal line, drawn from x1 to x2
		//y1 is for y coordinate of horizontal line-1, y2 is for y coordinate of horizontal-line2
		
		Graphics2D g2 = (Graphics2D) g;
		g.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,40));
		g.setColor(new Color(255,0,255));
		g.drawString("TIC TAC TOE",185,50);
		setBackground(Color.WHITE);
		g.setColor(new Color(0,0,0));
		
		g2.setStroke(new BasicStroke(5));
		g.drawLine(vlx1, vly1, vlx1, vly2);
		g.drawLine(vlx2, vly1, vlx2, vly2);
		g.drawLine(hlx1, hly1, hlx2, hly1);
		g.drawLine(hlx1, hly2, hlx2, hly2);
		int i=0,j=0;
		
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				g.setFont(new Font("Calibri",Font.BOLD,100));
				g2.setStroke(new BasicStroke(10));
				if(grid[i][j]==1)
				{
					g.setColor(new Color(255,0,0));
					g.drawString("X",i*s+x0+s/4,j*s+y0+s/2+s/4);
				}
				if(grid[i][j]==-1)
				{
					g.setColor(new Color(0,0,255));
					g.drawString("O",i*s+x0+s/4,j*s+y0+s/2+s/4);
				}
			}
		}
		if((grid[0][0]+grid[0][1]+grid[0][2])==3 || (grid[0][0]+grid[1][0]+grid[2][0])==3 || (grid[0][0]+grid[1][1]+grid[2][2])==3 || (grid[0][1]+grid[1][1]+grid[2][1])==3 || (grid[0][2]+grid[1][2]+grid[2][2])==3 || (grid[1][0]+grid[1][1]+grid[1][2])==3 || (grid[2][0]+grid[2][1]+grid[2][2])==3 || (grid[2][0]+grid[1][1]+grid[0][2])==3)
		{
			g.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,50));
			g.setColor(new Color(0,255,0));
			g.drawString("X Wins!",225,600);
			
		}
		if((grid[0][0]+grid[0][1]+grid[0][2])==-3 || (grid[0][0]+grid[1][0]+grid[2][0])==-3 || (grid[0][0]+grid[1][1]+grid[2][2])==-3 || (grid[0][1]+grid[1][1]+grid[2][1])==-3 || (grid[0][2]+grid[1][2]+grid[2][2])==-3 || (grid[1][0]+grid[1][1]+grid[1][2])==-3 || (grid[2][0]+grid[2][1]+grid[2][2])==-3 || (grid[2][0]+grid[1][1]+grid[0][2])==-3)
		{
			g.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,50));
			g.setColor(new Color(0,255,0));
			g.drawString("O Wins!",225,600);
		}
	}
	
	public static void main(String args[])
	{
		tictactoe m = new tictactoe();
		m.addMouseListener(m);
		JFrame f = new JFrame();
		f.add(m);
		f.setSize(600,600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	int grid[][] = new int[3][3];
	int xi=0,yi=0;
	int x0=75,y0=90;
	int x=0,y=0;
	int s=150;
	boolean xplays=true;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		x=e.getX();
		y=e.getY();
		
		xi = (x-x0)/s; //x index of the grid array
		yi = (y-y0)/s; //y index of the grid array 
		
		if(grid[xi][yi] == 0)
		{
			if(xplays)
			{
				grid[xi][yi]=1;
			}
			else
			{
				grid[xi][yi]=-1;
			}
			xplays = !xplays;
		}
		repaint();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
