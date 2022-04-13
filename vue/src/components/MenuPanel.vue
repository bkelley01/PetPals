<template>
    <div class="menu">
        <ul>
            <li>Profile</li>
            <li>Playdates</li>
            <li>Messages</li>
            <li v-if="$store.state.token != ''" class="menu-item"><router-link v-bind:to="{ name: 'logout' }" >Logout</router-link></li>
            <li v-if="$store.state.token == ''" class="menu-item"><router-link v-bind:to="{ name: 'login' }" >Login</router-link></li>
        </ul>
    </div>
</template>

<script>
export default {
    name: 'menu-panel'
}
</script>

<style>


</style>