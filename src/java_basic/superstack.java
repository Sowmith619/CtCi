package java_basic;

public class superstack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String[] cmds = {"14", "PUSH 4", "POP", "PUSH 3", "PUSH 5", "PUSH 2"
				    , "INC 3 1", "POP", "PUSH 1", "INC 2 2", "PUSH 4"
				    , "POP", "POP", "PUSH 10", "PUSH 11"};
		  superstack(cmds);
	}
	//Print value of "peak" after each operation.
	public static void superstack(String[] cmds) {
		
		int n = Integer.parseInt(cmds[0]);
		int[] stack = new int[n];
		int here = -1;
		for(int i=1;i<cmds.length;i++) {
			String[] split = cmds[i].split(" ");
			if(split[0].equals("PUSH")) {
				stack[++here]=Integer.parseInt(split[1]);
				System.out.println(stack[here]);
			}else if(split[0].equals("INC")) {
				int count = Integer.parseInt(split[1]);
				int increment = Integer.parseInt(split[2]);
				for(int j=0;j<count;j++)
					stack[j] = stack[j]+increment;
				System.out.println(stack[here]);
			}else if(cmds[i].equals("POP")) {
				if(here==0) {
					here--;
					System.out.println("EMPTY");
				}else {
					here--;
					System.out.println(stack[here]);
				}
			}
		}
	}

}
