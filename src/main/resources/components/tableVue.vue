<template>
    <div class="tableItems">
        <br>
        <table border=3 bgcolor=#fff width=100%>
            <div v-for="item in items">
            <tr align=center>
                <td>
                    <div>
                        <img src="https://i.imgur.com/eIaTAW1.png" height="27" width="350"/>
                        <a href="/example1" class="text">Велосипед горный CUBE Reaction Race</a>
                        <img src="https://cdn.sptmr.ru/upload/resize_cache/iblock/02b/370_416_1/27965120299.jpg" height="176" width="296"/>
                        <br><br><span class="price">16.715,00 руб</span>
                    </div>
                </td>
                <td>
                    <div>
                        <img src="https://i.imgur.com/eIaTAW1.png" height="27" width="350"/>
                        <a href="/example2" class="text">Велосипед горный Trek X-Caliber 9 29"</a>
                        <img src="https://cdn.sptmr.ru/upload/resize_cache/iblock/f5f/370_416_1/27966980299.jpg" height="176" width="296"/>
                        <br><br><span class="price">19.700,00 руб</span>
                    </div>
                </td>
                <td>
                    <div>
                        <img src="https://i.imgur.com/eIaTAW1.png" height="27" width="350"/>
                        <a href="/example3" class="text">Велосипед шоссейный Trek CHECKPOINT</a>
                        <img src="https://cdn.sptmr.ru/upload/resize_cache/iblock/b42/370_416_1/27966090299.jpg" height="176" width="296"/>
                        <br><br><span class="price">28.390,00 руб</span>
                    </div>
                </td>
            </tr>
            <br><br>
            </div>
        </table>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                items: [
                    '1','2','3'
                ]
            }
        },
    }
</script>

<style scoped>
    .tableItems {
       padding-top: 90px;
    }
    .text {
        position: relative;
        top: -26px;
        text-decoration: none;
        font: 12pt Helvetica, sans-serif;
        font-weight: 500;
        color: #161616;
    }
    .price {
        font: 16pt Helvetica, sans-serif;
        font-weight: 500;
        color: #161616;
    }
    TABLE {
        border-collapse: collapse;
        border: 0px;
    }
    TD, TH {
        padding: 3px; /* Поля вокруг содержимого таблицы */
        border: 0px; /* Параметры рамки */
    }
</style>