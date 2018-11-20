package com.xuxu.sprd.agent;

/**测试静态代理
 * Created by martea on 2018/11/20.
 */
public class StaticAgent {

    public static void main(String[] args) {
        Singer singer = new Agent(new Star());
        singer.sing();
    }


    static class Agent implements Singer{

        Star s;

        public Agent(Star s) {
            this.s = s;
        }

        public void sing() {
            System.out.println("代理方法执行");
            s.sing();
        }
    }


    static class Star implements Singer{

        public void sing() {
            System.out.println("Sing a song !");
        }
    }




    interface Singer{
        void sing();
    }
}
