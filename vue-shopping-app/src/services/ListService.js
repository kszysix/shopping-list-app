import axios from "axios";

const BASE_API_URL = "http://localhost:8080/api/v1";
const LIST_API_URL = `${BASE_API_URL}/list/`;

class ListService {
    getLists() {
        return axios.get(LIST_API_URL);
    }

    getListItems(listId) {
        return axios.get(LIST_API_URL + listId + "/items");
    }

    createList(listName) {
        const listObj = {"name": listName, "price": 0}
        return axios.post(LIST_API_URL, listObj);
    }

    deleteList(listId) {
        return axios.delete(LIST_API_URL + listId);
    }
}

export default new ListService();