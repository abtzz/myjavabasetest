package net.btnz.pri.java.myjavabasetest.asm;/**
 * Created by zhangsongwei on 2017/2/3.
 */

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @author: Balter Notz [BalterNotz@foxmail.com]
 * @Date: 2017/2/3 15:48
 */
public class AopClassAdapter extends ClassVisitor implements Opcodes {
    public AopClassAdapter(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        //对test开头的方法进行特殊处理
        if (name.startsWith("test")) {
            mv = new AopMethodVisitor(this.api, mv);
        }
        return mv;
    }
}
