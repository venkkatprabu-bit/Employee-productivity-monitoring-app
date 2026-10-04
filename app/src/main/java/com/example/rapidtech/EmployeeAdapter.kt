package com.example.rapidtech

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(
    private val employees: List<Employee>
) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    class EmployeeViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val txtEmployeeName =
            itemView.findViewById<TextView>(
                R.id.txtEmployeeName
            )

        val txtEmployeeCode =
            itemView.findViewById<TextView>(
                R.id.txtEmployeeCode
            )

        val txtDesignation =
            itemView.findViewById<TextView>(
                R.id.txtDesignation
            )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_employee,
                    parent,
                    false
                )

        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: EmployeeViewHolder,
        position: Int
    ) {

        val employee =
            employees[position]

        holder.txtEmployeeName.text =
            employee.employeeName

        holder.txtEmployeeCode.text =
            employee.employeeCode

        holder.txtDesignation.text =
            employee.designation
    }

    override fun getItemCount(): Int {

        return employees.size
    }
}