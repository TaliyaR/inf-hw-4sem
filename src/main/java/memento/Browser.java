package memento;

import memento.page.Page;

public class Browser {
    private Page currentPage;
    private History history;
    //может создавать снимок

    public Browser() {
        this.history = new History();
//        ArrayList<Page> links = new ArrayList<>();
//        links.add(new Page("Site1"));
//        links.add(new Page("Site2"));
//        links.add(new Page("Site3"));
//        links.add(new Page("Site4"));

//        this.currentPage = new Page("Page1", links);
//        history.push(new Memento(this, currentPage));
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void back(){
        history.back();
    }

    public void forward(){
        history.forward();
    }

    //стек forward пустой
    public void goTo(String name){
        currentPage = new Page(name);
        history.push(new Memento(this, currentPage));
        history.clearForwardStack();
        System.out.println("go to " + name);
    }

    //стек forward пустой
    public void link(String name){
        if(currentPage.hasLink(name)){
            currentPage = new Page(name);
            history.push(new Memento(this, currentPage));
            history.clearForwardStack();
            System.out.println("link to " + name);
        }else {
            System.out.println("ссылки не существует");
        }
    }

    //восстановление состояния в снимке
    private void restore(Page page){
        currentPage = page;
    }

    //сохранение состояния в снимке
    public Memento save(){
        return new Memento(this, currentPage);
    }

    class Memento {
        private Browser browser;
        private Page currentPage;

        public Memento(Browser browser, Page currentPage) {
            this.browser = browser;
            this.currentPage = currentPage;
        }

        //восстановление состояния браузера
        public void restore(){
            browser.restore(currentPage);
        }
    }
}
