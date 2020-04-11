<template>
    <div>
        <v-content>
            <router-view />
        </v-content>
    </div>
</template>

<script>
    export default {
        name: 'app',
        component: {
        },
        data() {
            return {
                auth: null
            }
        },
        created() {
            this.auth = localStorage.getItem("login")
        },
        methods: {

        }
    }
</script>

<style>
    .header {
        height: 48px;
        width: 100%; /* Ширина второго слоя */
        background: #161616; /* Цвет фона */
        position: absolute;
        margin: 0;
        padding: 0;
        display: block;
    }
    body {
        margin: 0;
    }
</style>