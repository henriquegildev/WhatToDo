package pt.ipbeja.whattodo.ui.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pt.ipbeja.whattodo.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment() {

    private lateinit var binding: FragmentTodoListBinding

    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO instanciar o TodoAdapter e colocar no atributo 'adapter'

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
        // TODO configurar a RecyclerView
        //  atribuir o adapter criado no método [onCreate]
        //  atribuir um LinearLayoutManager
    }


    // TODO definir o TodoAdapter + TodoViewHolder

    inner class TodoAdapter // TODO extend RecyclerView.Adapter ...

    inner class TodoViewHolder // TODO extend RecyclerView.ViewHolder ...
}