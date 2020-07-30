/**
 * @author zoe
 **/
class AccessModifier {

  //私有(private)
  class Inner {
    private def f(): Unit = {
      println("f")
    }

    class InnerMost {
      f() //正确
    }

  }

  //(new Inner).f( ) 访问不合法是因为 f 在 Inner 中被声明为 private，而访问不在类 Inner 之内。但在 InnerMost 里访问 f 就没有问题的，因为这个访问包含在 Inner 类之内。Java中允许这两种访问，因为它允许外部类访问内部类的私有成员
  //(new Inner).f();//错误
}

//受保护的(protected)
package cn.wllsrx.zoe {

  class Super {
    protected def f() {
      println("f")
    }
  }

  class Sub extends Super {
    f()
  }

  class Other {
    //在 scala 中，对保护（Protected）成员的访问比 java 更严格一些。因为它只允许保护成员在定义了该成员的的类的子类中被访问。而在java中，用protected关键字修饰的成员，除了定义了该成员的类的子类可以访问，同一个包里的其他类也可以进行访问
    //(new Super).f();//错误
  }

}

//公共(public)
class Outer {

  class Inner {
    def f() {
      println("f")
    }

    class InnerMost {
      f()
    }

  }

  // 正确因为 f() 是 public
  (new Inner).f()
}

