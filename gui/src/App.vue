<template>
  <SkapaTestdata/>
  <UserLista/>
</template>

<script>
import UserLista from './components/UserLista.vue'
import SkapaTestdata from './components/SkapaTestdata.vue';

export default {
  name: 'App',
  components: {
    UserLista,
    SkapaTestdata
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
