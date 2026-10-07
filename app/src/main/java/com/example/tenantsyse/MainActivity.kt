package com.example.tenantsyse
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantsyse.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var lastTenant: Tenant? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val email = intent.getStringExtra("email")

        Toast.makeText(
            this,
            "Logged in as $email",
            Toast.LENGTH_LONG
        ).show()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.saveButton.setOnClickListener {

            if (binding.tenantNameEditText.text.toString().trim().isEmpty()) {
                binding.tenantNameEditText.error = "Tenant name is required"
                return@setOnClickListener
            }

            if (binding.phoneEditText.text.toString().trim().isEmpty()) {
                binding.phoneEditText.error = "Required"
                return@setOnClickListener
            }

            if (binding.rentEditText.text.toString().trim().isEmpty()) {
                binding.rentEditText.error = "Required"
                return@setOnClickListener
            }

            val name = binding.tenantNameEditText.text.toString()
            val phone = binding.phoneEditText.text.toString()
            val rent = binding.rentEditText.text.toString()
            val tenant = Tenant(name, phone, rent)

            binding.tenant = tenant
            lastTenant = tenant
            binding.tenantNameEditText.text.clear()
            binding.phoneEditText.text.clear()
            binding.rentEditText.text.clear()

        }


        binding.callButton.setOnClickListener {
            val tenant = lastTenant
            if (tenant == null) {
                Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${tenant.phone}"))
            startActivity(intent)
        }

        binding.shareButton.setOnClickListener {
            val tenant = lastTenant
            if (tenant == null) {
                Toast.makeText(this, "Save a tenant first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, tenant.summary())

            startActivity(Intent.createChooser(intent, "Share tenant"))
        }

    }
}