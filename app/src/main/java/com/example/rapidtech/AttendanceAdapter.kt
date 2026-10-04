package com.example.rapidtech

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AttendanceAdapter(
    private val attendanceList: List<Attendance>
) : RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {

    class AttendanceViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val txtAttendanceDate =
            itemView.findViewById<TextView>(
                R.id.txtAttendanceDate
            )

        val txtCheckIn =
            itemView.findViewById<TextView>(
                R.id.txtCheckIn
            )

        val txtCheckOut =
            itemView.findViewById<TextView>(
                R.id.txtCheckOut
            )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AttendanceViewHolder {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_attendance,
                    parent,
                    false
                )

        return AttendanceViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: AttendanceViewHolder,
        position: Int
    ) {

        val attendance =
            attendanceList[position]

        holder.txtAttendanceDate.text =
            attendance.date

        holder.txtCheckIn.text =
            "Check In : ${attendance.checkIn}"

        holder.txtCheckOut.text =
            "Check Out : ${attendance.checkOut}"
    }

    override fun getItemCount(): Int {

        return attendanceList.size
    }
}