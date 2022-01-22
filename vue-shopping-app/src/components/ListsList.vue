<template>
  <div class="container">
    <div v-if="!showList">
      <h3 class="text-center mb-4 mt-4">Lists</h3>
      <div class="container">
        <table class="table">
          <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Show</th>
            <th>Delete</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="list in lists" v-bind:key="list.id">
            <td>{{ list.id }}</td>
            <td>{{ list.name }}</td>
            <td>{{ list.price }}</td>
            <td><button v-on:click="changeShowList(list.id)">Show</button></td>
            <td><button v-on:click="deleteList(list.id)">Delete</button></td>
          </tr>
          <tr>
            <td>X</td>
            <td><input v-model="newListName" placeholder="Name"></td>
            <td>X</td>
            <td><button v-on:click="createNewList(newListName)">Add</button></td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div v-if="showList">
      <button v-on:click="showList = false">Back to lists</button>
      <ItemsList :listId="showListId"></ItemsList>
    </div>
  </div>
</template>
<script>
import ListService from "@/services/ListService";
import ItemsList from "@/components/ItemsList";
export default {
  name: "ListsList",
  data() {
    return {
      lists: [],
      items: [],
      showList: false,
      showListId: 0,
      newListName: "new list"
    };
  },
  components: {ItemsList},
  methods: {
    getLists() {
      ListService.getLists()
          .then(response => {
            this.lists = response.data;
          });
    },
    changeShowList(listId) {
      this.showListId = listId;
      this.showList = true;
    },
    createNewList(name) {
      ListService.createList(name)
          .then(() => {
            this.getLists();
            this.newListName = "new list";
          });
    },
    deleteList(listId) {
      ListService.deleteList(listId)
          .then(() => {
            this.getLists();
          });
    }
  },
  created() {
    this.getLists();
  }
};
</script>
<style>
</style>