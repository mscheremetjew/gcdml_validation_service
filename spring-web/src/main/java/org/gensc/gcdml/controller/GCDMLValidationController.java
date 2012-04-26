package org.gensc.gcdml.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.gensc.gcdml.springmvc.model.UploadItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Represents a controller for the info page.
 *
 * @author Maxim Scheremetjew, EMBL-EBI, InterPro
 * @since 1.0-SNAPSHOT
 */
@Controller
@RequestMapping(value = "/" + GCDMLValidationController.VIEW_NAME)
public class GCDMLValidationController {
    private final Log log = LogFactory.getLog(GCDMLValidationController.class);

    /**
     * View name of this controller which is used several times.
     */
    public static final String VIEW_NAME = "validate";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getValidateForm(final ModelMap model) {
        model.addAttribute(new UploadItem());
        model.addAttribute("name", "fileName placeholder");
        return new ModelAndView(VIEW_NAME, model);
    }

    @RequestMapping(value = "showReport", method = RequestMethod.GET)
    public ModelAndView showReportPage(final ModelMap model) {
        model.addAttribute("name", "fileName placeholder");
        return new ModelAndView("showReport", model);
    }

    @RequestMapping(value = "failed", method = RequestMethod.GET)
    public ModelAndView showFailedPage(ModelMap model) {
        model.addAttribute(new UploadItem());
        model.addAttribute("name", "fileName placeholder");
        return new ModelAndView(VIEW_NAME, model);
    }

    @RequestMapping(value = "doValidation", method = RequestMethod.POST)
    public ModelAndView doValidation(@ModelAttribute("uploadItem") final UploadItem uploadItem, final ModelMap model) {
//        public ModelAndView doValidation(@ModelAttribute("uploadItem") @RequestParam("file") MultipartFile file, ModelMap model) {
        MultipartFile file = uploadItem.getFileData();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            model.addAttribute("name", file.getName());
            // store the bytes somewhere
            return new ModelAndView("redirect:showReport", model);
        } else {
            return new ModelAndView("/failed", model);
        }
    }


//    @RequestMapping(method = RequestMethod.POST)
//    public String create(UploadItem uploadItem, BindingResult result) {
//        if (result.hasErrors()) {
//            for (ObjectError error : result.getAllErrors()) {
//                System.err.println("Error: " + error.getCode() + " - " + error.getDefaultMessage());
//            }
//            return "/doUpload";
//        }
//
//        // Some type of file processing...
//        System.out.println("-------------------------------------------");
//        System.out.println("Test upload: " + uploadItem.getName());
//        System.out.println("Test upload: " + uploadItem.getFileData().getOriginalFilename());
//        System.out.println("-------------------------------------------");
//
//        return "redirect:/app/";
//    }
}