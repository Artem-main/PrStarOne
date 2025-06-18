package SpringBean.pack;

import org.springframework.stereotype.Component;

@Component
public class FirstBean {

    public FirstBean(PrototypeBean prototypeBean) {
        System.out.println("\n\n\nI'm FirstBean\n\n\n");
//        System.out.println(prototypeBean.toString() + "\n\n\n");
        System.out.println(prototypeBean.toString());
    }
}
