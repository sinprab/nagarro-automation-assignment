Feature: Test different interactions of jquery website

  Background:
    Given Launch jquery website

  @E2EJquery @Droppable
  Scenario: Test Droppable Interaction
    When User selects option "Droppable" from left menu under Interactions
    And User Drag ‘Drag me around’ component to ‘Drop here’ component
    Then ‘Drag me around’ component must get dragged ‘Drop here’ component

  @E2EJquery @Selectable
  Scenario: Test Selectable Interaction
    When User selects option "Selectable" from left menu under Interactions
    And User Selects <Item>
    |Item 1|
    |Item 3|
    |Item 7|
    Then All specified item must get selected

  @E2EJquery @ControlGroup
  Scenario Outline: Test Control Group Widget
    When User selects option "Controlgroup" from left menu under Interactions
    And User Book Car with details "<carType>","<transmissionType>","<NumberOfCar>"
  Examples:
    | carType | transmissionType | NumberOfCar |
    |SUV      |Automatic         | 2           |
    |Truck    | Standard         | 1           |

