package memento;

import memento.page.Page;

public class Browser {
    private Page currentPage;
    private History history;
    //может создавать снимок

    public Browser() {
        this.history = new History();
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
        history.push(save());
        history.clearForwardStack();
        System.out.println("go to " + name);
    }

    //стек forward пустой
    public void link(String name){
        if(currentPage.hasLink(name)){
            currentPage = new Page(name);
            history.push(save());
            history.clearForwardStack();
            System.out.println("link to " + name);
        }else {
            System.out.println("ссылки не существует");
        }
    }

    public void goToPosition(Integer position) {
        if (!currentPage.changePosition(position)) {
            System.out.println("Неправильная позиция");
        }
    }

    public void goToAd() {
        Page page;
        if ((page = currentPage.goToAd()) != null) {
            history.push(save());
            currentPage = page;
        } else {
            System.out.println("нет ads");
        }
    }

    //восстановление состояния в снимке
    private void restore(Page simplePage){
        currentPage = simplePage;
    }

    //сохранение состояния в снимке
    public Memento save(){
        return new Memento(this, currentPage);
    }

    class Memento {
        private Browser browser;
        private Page currentSimplePage;

        public Memento(Browser browser, Page currentSimplePage) {
            this.browser = browser;
            this.currentSimplePage = currentSimplePage;
        }

        //восстановление состояния браузера
        public void restore(){
            browser.restore(currentSimplePage);
        }
    }
}
