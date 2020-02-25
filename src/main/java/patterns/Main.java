package patterns;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Node root = new Node.Buider()
                .setName("Russia")
                .setPriority(1)
                .build();
        Node tatarstan = new Node.Buider().setName("Tatarstan").setParent(root).setPriority(1).setType(Type.REGION).build();
        Node samarskaya = new Node.Buider().setName("Samarskaya obl").setParent(root).setPriority(2).setType(Type.REGION).build();
        Node ulyanovskaya = new Node.Buider().setName("Ulyanovskaya obl").setParent(root).setPriority(3).setType(Type.REGION).build();

        Node arskDistrict = new Node.Buider().setName("Arskiy rayon").setParent(tatarstan).setPriority(1).setType(Type.DISTRICT).build();
        Node kukmorskiDistrict = new Node.Buider().setName("Kukmorsri rayon").setParent(tatarstan).setPriority(2).setType(Type.DISTRICT).build();
        Node syzranskiDistrict = new Node.Buider().setName("Syzranski rayon").setParent(samarskaya).setPriority(1).setType(Type.DISTRICT).build();
        Node baryshskiDistrict = new Node.Buider().setName("Baryshski rayon").setParent(ulyanovskaya).setPriority(2).setType(Type.DISTRICT).build();
        Node inzenskiDistrict = new Node.Buider().setName("Inzenski rayon").setParent(ulyanovskaya).setPriority(1).setType(Type.DISTRICT).build();

        Node arsk = new Node.Buider().setName("Arsk").setParent(arskDistrict).setPriority(1).setType(Type.CITY).build();
        Node kukmor = new Node.Buider().setName("Kukmora").setParent(kukmorskiDistrict).setPriority(1).setType(Type.CITY).build();
        Node syzran = new Node.Buider().setName("Syzran").setParent(syzranskiDistrict).setPriority(1).setType(Type.CITY).build();
        Node inza = new Node.Buider().setName("Inza").setParent(inzenskiDistrict).setPriority(1).setType(Type.CITY).build();
        Node barysh = new Node.Buider().setName("Barysh").setParent(baryshskiDistrict).setPriority(1).setType(Type.CITY).build();

        Node lesnaya = new Node.Buider().setName("Lesnaya").setParent(arsk).setPriority(1).setType(Type.STREET).build();

        Node h4 = new Node.Buider().setName("4").setParent(lesnaya).setPriority(1).setType(Type.HOUSE).build();

        root.addChild(samarskaya);
        root.addChild(tatarstan);
        root.addChild(ulyanovskaya);
        tatarstan.addChild(kukmorskiDistrict);
        tatarstan.addChild(arskDistrict);
        samarskaya.addChild(syzranskiDistrict);
        ulyanovskaya.addChild(baryshskiDistrict);
        ulyanovskaya.addChild(inzenskiDistrict);
        arskDistrict.addChild(arsk);
        kukmorskiDistrict.addChild(kukmor);
        syzranskiDistrict.addChild(syzran);
        inzenskiDistrict.addChild(inza);
        baryshskiDistrict.addChild(barysh);
        arsk.addChild(lesnaya);
        lesnaya.addChild(h4);

        Tree tree = new Tree(root);
//

//        patterns.BfsIterator iterator = new patterns.BfsIterator(tree);
//        while (iterator.hasNext()){
//            System.out.print(iterator.next());
//        }
//        System.out.println();
//
//        patterns.BfsPriorityIterator iteratorPriority = new patterns.BfsPriorityIterator(tree);
//        while (iteratorPriority.hasNext()){
//            System.out.print(iteratorPriority.next());
//        }
//        System.out.println();
//
//        patterns.DfsIterator dfsIterator = new patterns.DfsIterator(tree);
//        while (dfsIterator.hasNext()){
//            System.out.print(dfsIterator.next());
//        }
//    }
        SaveTreeFacade converter = SaveTreeFacade.getInstance();
        System.out.println();
//        patterns.BfsIterator iterator = new patterns.BfsIterator(converter.decodeJson(converter.createJson(tree)));
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().getName());
//        }
        //File xmlFile = converter.writeTree(tree);
//        converter.createXml(tree);
        Tree tree1 = converter.decodeXml();
        BfsPriorityIterator iteratorPriority = new BfsPriorityIterator(tree1);
        while (iteratorPriority.hasNext()){
            System.out.print(iteratorPriority.next());
        }



        Interpreter interpreter = new Interpreter();
        interpreter.returnChildren("return children REGION Tatarstan", tree);



    }
}
