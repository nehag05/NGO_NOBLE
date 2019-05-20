package com.app.nobleapp;


import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import java.util.ArrayList;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.SmsManager;
import java.io.IOException;
import android.widget.Button;
import android.location.Geocoder;
import android.location.Address;
import java.util.List;
import java.util.Locale;
import android.view.View.OnClickListener;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;



public class HelpFragment extends Fragment {

    public HelpFragment() {
    }

    public View mainView = null;

    public String gpsLocation = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_help, container, false);

        Button getGpsLoc = (Button) rootView.findViewById(R.id.getLocBtn);
        getGpsLoc.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setGPSLocation(rootView);
            }
        });

        Button submitBtn = (Button) rootView.findViewById(R.id.helpSubmit);
        submitBtn.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                submitData(rootView);
            }
        });


        mainView = rootView;
        return rootView;
    }

    public void submitData(View clickedView){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity(), R.style.Theme_AppCompat_Dialog_Alert);
        // set title
        alertDialogBuilder.setTitle("NobleApp");
        // set dialog message
        String message = "Privacy Policy\n" +
                "Marvel built the NobleApp app as a Free app. This SERVICE is provided by Marvel at no cost and is intended for use as is.\n" +
                "\n" +
                "This page is used to inform visitors regarding my policies with the collection, use, and disclosure of Personal Information if anyone decided to use my Service.\n" +
                "\n" +
                "If you choose to use my Service, then you agree to the collection and use of information in relation to this policy. The Personal Information that I collect is used for providing and improving the Service. I will not use or share your information with anyone except as described in this Privacy Policy.\n" +
                "\n" +
                "The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which is accessible at NobleApp unless otherwise defined in this Privacy Policy.\n" +
                "\n" +
                "Information Collection and Use\n" +
                "\n" +
                "For a better experience, while using our Service, I may require you to provide us with certain personally identifiable information. The information that I request will be retained on your device and is not collected by me in any way.\n" +
                "\n" +
                "The app does use third party services that may collect information used to identify you.\n" +
                "\n" +
                "Link to privacy policy of third party service providers used by the app\n" +
                "\n" +
                "Google Play Services\n" +
                "Log Data\n" +
                "\n" +
                "I want to inform you that whenever you use my Service, in a case of an error in the app I collect data and information (through third party products) on your phone called Log Data. This Log Data may include information such as your device Internet Protocol (“IP”) address, device name, operating system version, the configuration of the app when utilizing my Service, the time and date of your use of the Service, and other statistics.\n" +
                "\n" +
                "Cookies\n" +
                "\n" +
                "Cookies are files with a small amount of data that are commonly used as anonymous unique identifiers. These are sent to your browser from the websites that you visit and are stored on your device's internal memory.\n" +
                "\n" +
                "This Service does not use these “cookies” explicitly. However, the app may use third party code and libraries that use “cookies” to collect information and improve their services. You have the option to either accept or refuse these cookies and know when a cookie is being sent to your device. If you choose to refuse our cookies, you may not be able to use some portions of this Service.\n" +
                "\n" +
                "Service Providers\n" +
                "\n" +
                "I may employ third-party companies and individuals due to the following reasons:\n" +
                "\n" +
                "To facilitate our Service;\n" +
                "To provide the Service on our behalf;\n" +
                "To perform Service-related services; or\n" +
                "To assist us in analyzing how our Service is used.\n" +
                "I want to inform users of this Service that these third parties have access to your Personal Information. The reason is to perform the tasks assigned to them on our behalf. However, they are obligated not to disclose or use the information for any other purpose.\n" +
                "\n" +
                "Security\n" +
                "\n" +
                "I value your trust in providing us your Personal Information, thus we are striving to use commercially acceptable means of protecting it. But remember that no method of transmission over the internet, or method of electronic storage is 100% secure and reliable, and I cannot guarantee its absolute security.\n" +
                "\n" +
                "Links to Other Sites\n" +
                "\n" +
                "This Service may contain links to other sites. If you click on a third-party link, you will be directed to that site. Note that these external sites are not operated by me. Therefore, I strongly advise you to review the Privacy Policy of these websites. I have no control over and assume no responsibility for the content, privacy policies, or practices of any third-party sites or services.\n" +
                "\n" +
                "Children’s Privacy\n" +
                "\n" +
                "These Services do not address anyone under the age of 13. I do not knowingly collect personally identifiable information from children under 13. In the case I discover that a child under 13 has provided me with personal information, I immediately delete this from our servers. If you are a parent or guardian and you are aware that your child has provided us with personal information, please contact me so that I will be able to do necessary actions.\n" +
                "\n" +
                "Changes to This Privacy Policy\n" +
                "\n" +
                "I may update our Privacy Policy from time to time. Thus, you are advised to review this page periodically for any changes. I will notify you of any changes by posting the new Privacy Policy on this page. These changes are effective immediately after they are posted on this page.\n" +
                "\n" +
                "Contact Us\n" +
                "\n" +
                "If you have any questions or suggestions about my Privacy Policy, do not hesitate to contact me at Marvel Team.\n" +
                "\n" +
                "This privacy policy page was created at privacypolicytemplate.net and modified/generated by App Privacy Policy Generator\n" +
                "\n";
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setCancelable(true);

        alertDialogBuilder.setNeutralButton(android.R.string.ok,

                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        TextView nameView = (TextView)mainView.findViewById(R.id.victimName);
                        TextView addressView = (TextView)mainView.findViewById(R.id.victimAddress);
                        Spinner causeView = (Spinner) mainView.findViewById(R.id.victimProblemCause);

                        String problem = causeView.getSelectedItem().toString();
                        TextView phoneView = (TextView)mainView.findViewById(R.id.victimPhone);
                        try {
                            SmsManager smsManager = SmsManager.getDefault();
                            smsManager.sendTextMessage("9890828920", null, "Help required, Name : " + nameView.getText().toString() + "\n Location : "+ gpsLocation
                                    + "\n Problem : "+ problem, null, null);
                            Toast.makeText(getActivity().getApplicationContext(), "Message Sent",
                                    Toast.LENGTH_LONG).show();
                        } catch (Exception ex) {
                            Toast.makeText(getActivity().getApplicationContext(),ex.getMessage().toString(),
                                    Toast.LENGTH_LONG).show();
                            ex.printStackTrace();
                        }

                        Toast.makeText(getActivity().getBaseContext(), "Please dont panic, we will get back to you shortly", Toast.LENGTH_LONG).show();

                    }
                });

        AlertDialog alert11 = alertDialogBuilder.create();
        try {
            alert11.show();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void setGPSLocation(View clickedView){
        LocationListenerClass locationListenerObj = new LocationListenerClass();
        LocationManager locationManager = (LocationManager)
                getActivity().getSystemService(getActivity().getBaseContext().LOCATION_SERVICE);
        try {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, 5000, 10, locationListenerObj);
        }catch(SecurityException seExc){
            Toast.makeText(getActivity().getBaseContext(), "Please give permissions for access", Toast.LENGTH_LONG).show();
        }
    }

    class LocationListenerClass implements LocationListener {

        @Override
        public void onLocationChanged(Location loc) {
            Toast.makeText(getActivity().getApplicationContext(),
                    "Location changed: Lat: " + loc.getLatitude() + " Lng: "
                            + loc.getLongitude(), Toast.LENGTH_SHORT).show();
            String longitude = "Longitude: " + loc.getLongitude();
            String latitude = "Latitude: " + loc.getLatitude();
            String cityName = null;
            String countryName = null;
            Geocoder gcd = new Geocoder(getActivity().getBaseContext(), Locale.getDefault());
            List<Address> addresses;
            try {
                addresses = gcd.getFromLocation(loc.getLatitude(),
                        loc.getLongitude(), 1);
                if (addresses.size() > 0) {
                    System.out.println(addresses.get(0).getLocality());
                    cityName = addresses.get(0).getLocality();
                    countryName = addresses.get(0).getCountryName();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            String s = longitude + "\n" + latitude + "\n\nCity : "
                    + cityName + "\n\n Country : " + countryName;
            gpsLocation = s;
            Toast.makeText(getActivity().getBaseContext(), s, Toast.LENGTH_LONG).show();
        }
        @Override
        public void onProviderDisabled(String provider) {}

        @Override
        public void onProviderEnabled(String provider) {}

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}
    }
}
