<template>
  <div id="app">
    <h1>Paginated List</h1>
    <ul>
      <li v-for="item in paginatedData" :key="item.name">{{ item.name }}, {{ item.address }}, {{ item.email }}, {{ item.telephone }} </li>
    </ul>
    <button @click="prevPage" :disabled="page === 1">Previous</button>
    <button @click="nextPage" :disabled="page === totalPages">Next</button>
    <p>Page {{ page }} of {{ totalPages }}</p>
  </div>
</template>

<script>
import { ref, onMounted, computed } from 'vue';
import axios from 'axios';

export default {
  name: 'App',
  setup() {
    const items = ref([]);
    const page = ref(1);
    const perPage = 5;

    const fetchItems = async () => {
      try {
        const response = await axios.get('http://localhost:8080/ggid/user');

        items.value = response.data;
        console.log(items);
      } catch (error) {
        console.error(error);
      }
    };

    const paginatedData = computed(() => {
      const start = (page.value - 1) * perPage;
      const end = start + perPage;
      return items.value.slice(start, end);
    });

    const totalPages = computed(() => {
      return Math.ceil(items.value.length / perPage);
    });

    const prevPage = () => {
      if (page.value > 1) {
        page.value--;
      }
    };

    const nextPage = () => {
      if (page.value < totalPages.value) {
        page.value++;
      }
    };

    onMounted(fetchItems);

    return {
      items,
      page,
      perPage,
      paginatedData,
      totalPages,
      prevPage,
      nextPage,
    };
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  background: #f4f4f4;
  margin: 10px 0;
  padding: 10px;
  border-radius: 4px;
}
button {
  margin: 5px;
  padding: 10px 20px;
  border: none;
  background-color: #42b983;
  color: white;
  border-radius: 5px;
  cursor: pointer;
}
button:disabled {
  background-color: #cccccc;
}
</style>
