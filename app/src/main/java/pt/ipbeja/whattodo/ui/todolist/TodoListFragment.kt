package pt.ipbeja.whattodo.ui.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.ipbeja.whattodo.R
import pt.ipbeja.whattodo.databinding.FragmentTodoListBinding
import pt.ipbeja.whattodo.databinding.TodoListItemBinding
import pt.ipbeja.whattodo.model.Todo

class TodoListFragment : Fragment() {

    private lateinit var binding: FragmentTodoListBinding

    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.adapter = TodoAdapter()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclelist.adapter = this.adapter
        binding.recyclelist.layoutManager = LinearLayoutManager(requireContext())
        val todoList = MutableList(5)
        {
            Todo(it.toLong(), "TODO #$it", "Description #$it")
        }

        binding.addFab.setOnClickListener{
            val i = todoList.size
            val todoItem = Todo(i.toLong(), "TODO #($i)", "Description #$i")
            todoList.add(todoItem)
            adapter.notifyItemInserted(todoList.size)
        }
        adapter.data = todoList

    }


    inner class TodoAdapter : RecyclerView.Adapter<TodoViewHolder>() {
        var data: MutableList<Todo> = mutableListOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.todo_list_item, parent, false)
            return TodoViewHolder(v)
        }

        override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
            var todoItem = data[position]
            holder.bind(todoItem)
        }

        override fun getItemCount(): Int {
            return data.size
        }
    }

    inner class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = TodoListItemBinding.bind(view)
        fun bind(todoItem: Todo) {
            binding.todoItemTitle.text = todoItem.title
            binding.todoItemDesc.text = todoItem.description
        }
    }
}