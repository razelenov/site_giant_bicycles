<template>
    <div>
        <div class="headerMenu">
            <div class="headerText">
                <a class="textLink" href="/about">
                    О нас
                </a>
                <span class="spliter">/</span>
                <a class="textLink" href="/contacts">
                    Контакты
                </a>
                <span class="spliter">/</span>
                <a class="textLink" href="/delivering">
                    Доставка
                </a>
                <span class="spliter">/</span>
                <a class="textLink" href="/shops">
                    Магазины
                </a>
            </div>
            <div>
                <img class="icons" src="https://i.imgur.com/PBhuuxs.png" height="17" width="124"/>
            </div>
        </div>
        <div class="topMenu">
            <div>
                <img class="topText" src="https://i.imgur.com/9LGs0E6.png" height="28" width="155"></img>
                <span class="topTextMenu">
                    <a class="menuText" href="/bike">
                        ВЕЛОСИПЕДЫ
                    </a>
                    <span class="spliter1">|</span>
                    <a class="menuText" href="/accessories">
                        АКСЕССУАРЫ
                    </a>
                    <span class="spliter1">|</span>
                    <a class="menuText" href="/new">
                        НОВИНКИ
                    </a>
                    <span class="spliter1">|</span>
                    <a class="menuText" href="/sale">
                        ПРОМОАКЦИИ
                    </a>
                    <a class="topTextMenuRight" href="/login">
                        ВОЙТИ
                    </a>
                    <span class="spliter2">|</span>
                    <img border="0" class="cart" src="https://i.imgur.com/aIMVXbB.png" height="14" width="16"/>
                    <a class="menuText1" href="/cart">
                        {{priceVal}} руб
                    </a>
                </span>
            </div>
        </div>
        <div class="lineMenu"></div>
        <main-vue></main-vue>
    </div>
</template>

<script>
    import mainVue from "../components/mainVue.vue";
    export default {
        data() {
            return {
                priceVal: "1.989,00"
            }
        },
        components: {
            'mainVue': mainVue
        },
    }
</script>

<style>
    .headerMenu {
        height: 37px;
        width: 100%; /* Ширина второго слоя */
        background: #161616; /* Цвет фона */
        margin: 0;
        padding: 0;
        display: block;
    }
    .lineMenu {
        height: 2px;
        width: 100%; /* Ширина второго слоя */
        background: #e5e6e6; /* Цвет фона */
        margin: 0;
        padding: 0;
        display: block;
        position: relative;
        top: 63px;
    }
    body {
        margin: 0;
    }
    .textLink {
        text-decoration: none;
        font: 8pt Helvetica, sans-serif;
        font-weight: bold;
        color: #575757;
    }
    .headerText {
        position: absolute;
        top: 7px;
        left: 45px;
    }
    .spliter {
        padding: 25px;
        font: 8pt Helvetica, sans-serif;
        font-weight: bold;
        color: #575757;
    }
    .icons {
        position: absolute;
        right: 25px;
        top: 10px;
    }
    .topMenu {
        left: 14%;
        right: 14%;
        position: absolute;
    }
    .topText {
        padding-top: 19px;
        padding-left: 28px;
    }
    .topTextMenu {
        top: -10px;
        padding-left: 30px;
        position: relative;
    }
    .topTextMenuRight {
        padding-left: 290px;
        text-decoration: none;
        font: 9pt system-ui;
        font-weight: 500;
        color: #575757;
    }
    .menuText {
        text-decoration: none;
        font: 9pt system-ui;
        font-weight: 500;
        color: #575757;
    }
    .spliter1 {
        padding: 12px;
        font: 9pt system-ui;
        font-weight: 500;
        color: #575757;
    }
    .spliter2 {
        padding-right: 12px;
        padding-left: 15px;
        font: 9pt system-ui;
        font-weight: 500;
        color: #575757;
    }
    .menuText1 {
        text-decoration: none;
        font: 9pt system-ui;
        font-weight: 500;
        color: #575757;
    }
    .cart {
        position: relative;
        top: 3px;
    }
</style>