<template>
    <div class="center">
        <p class="img"><a href="/speed"><img src="https://i.imgur.com/itWGo6J.png" height="417" width="737"/></a></p>
        <p class="img1"><a href="/mountain"><img src="https://i.imgur.com/RHioTuE.png" height="202" width="307"/></a></p>
        <p class="img2"><a href="/city"><img src="https://i.imgur.com/oXllEwo.png" height="202" width="307"/></a></p>
        <div class="block">

            <img class="car" src="https://i.imgur.com/riM4viy.png" height="30" width="42"/>
            <span class="title1">Бесплатная доставка до дома</span>
            <div class="text1">Мы бесплатно и быстро доставим вам товар при покупке от 4.000,00 руб и выше</div>

            <img class="fly" src="https://i.imgur.com/JezBrJJ.png" height="42" width="38"/>
            <span class="title2">Международная доставка товара</span>
            <div class="text2">Мы обеспечим международную доставку в вашу страну при заказе от 70.000,00 руб</div>

            <img class="cash" src="https://i.imgur.com/4JyAWjt.png" height="33" width="33"/>
            <span class="title3">Кешбэк на весь заказ</span>
            <div class="text3">Мы вернем часть стоимости вашего заказа в течение 14 дней после совершения покупки</div>
            <table-vue/>
        </div>
    </div>
</template>

<script>
    import tableVue from "../components/tableVue.vue";
    export default {
        name: "mainVue",
        data() {
            return {
            }
        },
        components: {
            'tableVue': tableVue
        }
    }
</script>

<style scoped>
    .car {
        position: absolute;
        top: 478px;
        left: 29px;
    }
    .cash {
        position: absolute;
        top: 478px;
        left: 782px;
    }
    .fly {
        position: absolute;
        top: 475px;
        left: 400px;
    }
    .img {
        left: 29px;
        position: relative;
    }
    .img1 {
        position: absolute;
        top: 0px;
        left: 780px;
    }
    .img2 {
        position: absolute;
        top: 215px;
        left: 780px;
    }
    .center {
        top: 111px;
        left: 14%;
        right: 14%;
        position: absolute;
    }
    .title1 {
        top: 468px;
        font: 11pt system-ui;
        font-weight: bold;
        color: #161616;
        position: absolute;
        left: 87px;
    }
    .text1 {
        font: 9pt system-ui;
        font-weight: 500;
        color: #7e7e7e;
        width: 250px;
        position: absolute;
        top: 492px;
        left: 87px;
    }
    .title2 {
        font: 11pt system-ui;
        font-weight: bold;
        color: #161616;
        position: absolute;
        left: 452px;
        top: 468px;
    }
    .text2 {
        font: 9pt system-ui;
        font-weight: 500;
        color: #7e7e7e;
        width: 250px;
        position: absolute;
        top: 492px;
        left: 452px;
    }
    .title3 {
        font: 11pt system-ui;
        font-weight: bold;
        color: #161616;
        position: absolute;
        left: 830px;
        top: 468px;
    }
    .text3 {
        font: 9pt system-ui;
        font-weight: 500;
        color: #7e7e7e;
        width: 270px;
        position: absolute;
        top: 492px;
        left: 830px;
    }
</style>