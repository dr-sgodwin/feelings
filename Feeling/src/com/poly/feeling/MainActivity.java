package com.poly.feeling;

import java.util.Random;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feeling);
		final TextView message = (TextView) findViewById(R.id.urfeeling);
		Button greenButton = (Button) findViewById(R.id.smile);
		Button yellowButton = (Button) findViewById(R.id.surprise);
		Button redButton = (Button) findViewById(R.id.anger);
		Button blueButton = (Button) findViewById(R.id.sick);

		final Random random = new Random();

		final SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		// final String phone = sharedPreferences.getString("phone_number",
		// "NA");
		// message.setText(phone);

		greenButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int messageNumber = random.nextInt(5) + 1;
				message.setText("Your smiling");
				switch (messageNumber) {
				case 1:
					message.append(" but, that's an evil smile...");
					break;
				case 2:
					message.append(" and you'll find that life is still worthwhile.");
					break;
				case 3:
					message.append(" and I am intrigued by that smile!");
					break;
				case 4:
					message.append(", it's a kiss, it's a sip of wine ... it's summertime!");
					break;
				case 5:
					message.append(" and your at your best when smiling.");
					break;
				} // Switch
			}
		}); // end of setOnClickListener

		yellowButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int messageNumber = random.nextInt(5) + 1;
				message.setText("Your surprised");
				switch (messageNumber) {
				case 1:
					message.append(", and you winked, you are wicked!");
					break;
				case 2:
					message.append(", but Scouts and women are never taken by suprise.");
					break;
				case 3:
					message.append(" \"Death can never take a wise man by surprise!\"");
					break;
				case 4:
					message.append(" and you surprise yourself, but No, you are in control.");
					break;
				case 5:
					message.append(" you are a success? and talented!");
					break;
				} // Switch
			}
		}); // end of setOnClickListener

		redButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int messageNumber = random.nextInt(5) + 1;
				message.setText("Your angry");
				switch (messageNumber) {
				case 1:
					message.append(", count to four; if very angry then swear!");
					break;
				case 2:
					message.append(" so get mad and then GET over it.");
					break;
				case 3:
					message.append(" which is the wind that blows out the lamp of the mind.");
					break;
				case 4:
					message.append(", but you should be too mature to be angry.");
					break;
				case 5:
					message.append(" and  a danger to small furry animals.");
					break;
				} // Switch
			}
		}); // end of setOnClickListener

		blueButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				String phoneNo = sharedPreferences.getString("phone_number",
						"NA");
				// String phoneNo = phone;
				String sms = sharedPreferences.getString("message_level", "2");
				// String sms =
				// "I am really sick. I will not be in to work today";
				int sick_level = Integer.parseInt(sms);
				if (sick_level == 1) {
					sms = "I am near Death and will not be in this week. Send flowers";
				}
				if (sick_level == 2) {
					sms = "I am sick, but will recover soon, Hence, I will not be in today.";
				}
				if (sick_level == 3) {
					sms = "I am not sick, but need a day off. Therefore I am not in today";
				}
				message.setText("Your Sick; The following message has been sent to your work:\n"
						+ sms);
				try {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(phoneNo, null, sms, null, null);
					Toast.makeText(getApplicationContext(),
							" SMS Sent to " + phoneNo, Toast.LENGTH_LONG)
							.show();
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(),
							"SMS faild, please try again later!",
							Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}
			}
		}); // end of setOnClickListener

	} // end of onCreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mainmenu, menu);
		return true;
	}

	// This method is called once the menu is selected
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			// Launch settings activity
			Intent i = new Intent(this, SettingsActivity.class);
			startActivity(i);
			break;
		// more code...
		}
		return true;
	}

}
